package app.components;

public class TwilioReply {
    private String sid;
    private String statusMessage;

    public TwilioReply(String sid, String statusMessage) {
        this.sid = sid;
        this.statusMessage = statusMessage;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}