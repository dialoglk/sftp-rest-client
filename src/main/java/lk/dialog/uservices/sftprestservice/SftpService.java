package lk.dialog.uservices.sftprestservice;


import lk.dialog.uservices.sftprestservice.models.AuthBundledCommand;
import lk.dialog.uservices.sftprestservice.models.FileProxyDirective;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SftpService {


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/fetch/echo",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String fetchAndEcho(AuthBundledCommand command) {
        return "FileContent";
    }



    @RequestMapping(
            method = RequestMethod.POST,
            value = "/fetch/push",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public boolean fetchAndPush(FileProxyDirective proxyDirective) {
        return false;
    }


}
