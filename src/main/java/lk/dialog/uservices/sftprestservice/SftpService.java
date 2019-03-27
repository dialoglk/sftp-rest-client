package lk.dialog.uservices.sftprestservice;


import com.jcraft.jsch.*;
import lk.dialog.uservices.sftprestservice.models.AuthBundledCommand;
import lk.dialog.uservices.sftprestservice.models.FileProxyDirective;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
public class SftpService {


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/fetch/echo",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String fetchAndEcho(@RequestBody AuthBundledCommand command) {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession(command.getUsername(), command.getEndpointAddress());
            session.setPassword(command.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();

            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
//            System.out.printf(command.getSubCommand());
            InputStream stream = sftpChannel.get(command.getSubCommand());

            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String read = "";
            while ((read = reader.readLine()) != null) {
                builder.append(read).append("\n");
            }
            /*while (stream.available() > 0) {
                System.out.println("reading " + stream.available() + " bytes");
                byte[] buffer = new byte[stream.available()];
                stream.read(buffer);
                builder.append(new String(buffer));
            }*/

            sftpChannel.disconnect();
            session.disconnect();
            System.out.println(builder.toString());
            return builder.toString();

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            switch (e.id) {
                case 3:
                    return "Permission Denied";
                case 4:
                    return "File not found";
                default:
                    return "File Error";

            }
        }

        return "error";
    }



    @RequestMapping(
            method = RequestMethod.POST,
            value = "/fetch/push",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean fetchAndPush(FileProxyDirective proxyDirective) {
        return false;
    }


    private UserInfo getUserInfoFromAuthData(AuthBundledCommand command) {

        UserInfo userInfo = new UserInfo() {
            @Override
            public String getPassphrase() {
                return command.getPassword();
            }

            @Override
            public String getPassword() {
                return command.getPassword();
            }

            @Override
            public boolean promptPassword(String s) {
                return false;
            }

            @Override
            public boolean promptPassphrase(String s) {
                return false;
            }

            @Override
            public boolean promptYesNo(String s) {
                return false;
            }

            @Override
            public void showMessage(String s) {

            }
        };

        return userInfo;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String deleteFile(@RequestBody AuthBundledCommand command) {
        JSch jSch = new JSch();
        try {
            Session session = jSch.getSession(command.getUsername(), command.getEndpointAddress());
            session.setPassword(command.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();

            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
//            System.out.printf(command.getSubCommand());
            sftpChannel.rm(command.getSubCommand());



            sftpChannel.disconnect();
            session.disconnect();

            return "Deleted";

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            switch (e.id) {
                case 3:
                    return "Permission Denied";
                case 4:
                    return "File not found";
                default:
                    return "File Error";

            }
        }

        return "error";
    }
}
