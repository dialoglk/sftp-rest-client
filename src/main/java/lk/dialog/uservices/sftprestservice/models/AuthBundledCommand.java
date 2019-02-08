package lk.dialog.uservices.sftprestservice.models;

import java.io.Serializable;

public class AuthBundledCommand implements Serializable {
    private String endpointAddress;
    private int endpointPort;
    private String username;
    private String password;
    private String command;
    private String subCommand;
    private String commandType;
    private String resultType;

    public String getEndpointAddress() {
        return endpointAddress;
    }

    public void setEndpointAddress(String endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    public int getEndpointPort() {
        return endpointPort;
    }

    public void setEndpointPort(int endpointPort) {
        this.endpointPort = endpointPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getSubCommand() {
        return subCommand;
    }

    public void setSubCommand(String subCommand) {
        this.subCommand = subCommand;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
