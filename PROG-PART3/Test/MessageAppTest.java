
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MessageAppTest {

    @Test
    public void testMessageAutoId() {
        Message msg1 = new Message("Alice", "Hello");
        Message msg2 = new Message("Bob", "Hi");

        assertEquals(1, msg1.getId());
        assertEquals(2, msg2.getId());
    }

    @Test
    public void testMessageManualId() {
        Message msg = new Message(42, "Charlie", "Test");

        assertEquals(42, msg.getId());
        assertEquals("Charlie", msg.getSender());
        assertEquals("Test", msg.getContent());
    }

    @Test
    public void testToString() {
        Message msg = new Message(5, "Derek", "Yo!");
        assertEquals("[5] Derek: Yo!", msg.toString());
    }

    @Test
    public void testSetters() {
        Message msg = new Message("Eve", "Hi");
        msg.setSender("Eva");
        msg.setContent("Hello again");

        assertEquals("Eva", msg.getSender());
        assertEquals("Hello again", msg.getContent());
    }
}

