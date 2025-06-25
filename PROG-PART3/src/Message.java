public class Message {
    private static int idCounter = 1;

    private int id;
    private String sender;
    private String content;

    // Constructor that auto-generates ID
    public Message(String sender, String content) {
        this.id = idCounter++;
        this.sender = sender;
        this.content = content;
    }

    // Constructor that accepts a manual ID
    public Message(int id, String sender, String content) {
        this.id = id;
        this.sender = sender;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + sender + ": " + content;
    }
}
