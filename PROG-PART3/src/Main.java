import java.util.Scanner;

public class Main {                            /* Joyce farrell, 2023 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageStore store = new MessageStore();

        while (true) {                                /* Joyce farrell, 2023 */
            System.out.println("\n--- QuickChat Menu ---");
            System.out.println("1. Send a message");
            System.out.println("2. View all messages");
            System.out.println("3. View message by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {                        /* Joyce farrell, 2023 */
                case "1":
                    System.out.print("Enter your name: ");
                    String sender = scanner.nextLine();
                    System.out.print("Enter your message: ");
                    String content = scanner.nextLine();

                    Message message = new Message(sender, content);
                    store.saveMessage(message);
                    System.out.println("Message sent!");
                    break;

                case "2":
                    System.out.println("\n--- All Messages ---");
                    for (Message m : store.getAllMessages()) {
                        System.out.println(m);
                    }
                    break;

                case "3":
                    System.out.print("Enter message ID: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        Message found = store.getMessageById(id);
                        if (found != null) {
                            System.out.println("Message Found:\n" + found);
                        } else {
                            System.out.println("No message with that ID.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
