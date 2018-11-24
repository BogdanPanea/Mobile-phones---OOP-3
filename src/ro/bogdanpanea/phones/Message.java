package ro.bogdanpanea.phones;

public class Message {

    private String bodyMessage;
    private String recipient;

    Message(String bodyMessage, String recipient) {
        this.bodyMessage = bodyMessage;
        this.recipient = recipient;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    String getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return "Message{" +
                "bodyMessage='" + bodyMessage + '\'' +
                ", recipient=" + recipient +
                '}';
    }
}
