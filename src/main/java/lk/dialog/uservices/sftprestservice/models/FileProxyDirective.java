package lk.dialog.uservices.sftprestservice.models;

import java.io.Serializable;

public class FileProxyDirective implements Serializable {
    private AuthBundledCommand sourceInfo;
    private AuthBundledCommand destinationInfo;

    public FileProxyDirective() {
    }

    public AuthBundledCommand getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(AuthBundledCommand sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public AuthBundledCommand getDestinationInfo() {
        return destinationInfo;
    }

    public void setDestinationInfo(AuthBundledCommand destinationInfo) {
        this.destinationInfo = destinationInfo;
    }
}
