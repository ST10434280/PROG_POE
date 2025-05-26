import java.util.*;
import java.io.*;
import javax.swing.JOptionPane; /* Joyce farrell, 2023 */
import com.google.gson.*;

public class Message {
    private static int totalMessages = 0;
    private static final List<Message> messageLog = new ArrayList<>();

    private String messageId;
    private int messageNumber;
    private String recipient;
    private String message;
    public String messageHash;

    public Message(String recipient, String message, String messageId, int messageNumber) {
        this.recipient = recipient;
        this.message = message;
        this.messageId = messageId;
        this.messageNumber = messageNumber;
    }

    public boolean checkMessageID() {   /* Joyce farrell, 2023 */
        return messageId.length() <= 10;
    }

    public boolean checkRecipientCell() {   /* Joyce farrell, 2023 */
        return recipient.length() <= 10 && recipient.startsWith("+");
    }

    public String createMessageHash() { /* Joyce farrell, 2023 */
        String[] words = message.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return messageId.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    public String sentMessage() { /* Joyce farrell, 2023 */
        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        int choice = JOptionPane.showOptionDialog(null, "Choose what to do with the message", "Send Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {   /* Joyce farrell, 2023 */
            case 0:
                totalMessages++;
                messageLog.add(this);
                return "Message successfully sent.";
            case 1:
                return "Message disregarded.";
            case 2:
                storeMessage();
                return "Message successfully stored.";
            default:
                return "No option selected.";
        }
    }

    public void storeMessage() {    /* Joyce farrell, 2023 */
        try (FileWriter writer = new FileWriter("messages.json", true)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String printMessages() {  /* Joyce farrell, 2023 */
        StringBuilder output = new StringBuilder();
        for (Message m : messageLog) {
            output.append("MessageID: ").append(m.messageId).append("\n");
            output.append("Message Hash: ").append(m.messageHash).append("\n");
            output.append("Recipient: ").append(m.recipient).append("\n");
            output.append("Message: ").append(m.message).append("\n\n");
        }
        return output.toString();
    }

    public static int returnTotalMessages() {   /* Joyce farrell, 2023 */
        return totalMessages;
    }
}

