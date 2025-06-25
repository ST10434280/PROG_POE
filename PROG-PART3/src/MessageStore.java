import java.io.*;
import java.util.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageStore {
    private static final String FILE_NAME = "messages.json";
    private List<Message> messages;

    public MessageStore() {
        messages = loadMessages();
    }

    private List<Message> loadMessages() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<Message>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void saveMessage(Message message) {
        messages.add(message);
        saveMessages();
    }

    private void saveMessages() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(messages, writer);
        } catch (IOException e) {
            System.err.println("Error saving messages: " + e.getMessage());
        }
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public Message getMessageById(int id) {
        for (Message m : messages) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}
