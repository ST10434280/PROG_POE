import java.util.*;
import javax.swing.JOptionPane; /* Joyce farrell, 2023 */

public class Main { /* Joyce farrell, 2023 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String fname = sc.nextLine();

        System.out.print("Enter your last name: ");
        String lname = sc.nextLine();

        Login login = new Login(fname, lname);

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (!login.checkUserName(username) || !login.checkPasswordComplexity(password)) {   /* Joyce farrell, 2023 */
            System.out.println("Login failed. Invalid credentials.");
            return;
        }

        System.out.println("Welcome to QuickChat.");

        int option = -1;
        while (option != 3) {   /* Joyce farrell, 2023 */
            System.out.println("1) Send Messages\n2) Show Recently Sent Messages\n3) Quit");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {   /* Joyce farrell, 2023 */
                case 1:
                    System.out.print("How many messages do you want to send? ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter recipient (+countrycode123): ");
                        String recipient = sc.nextLine();

                        System.out.print("Enter message: ");
                        String msg = sc.nextLine();

                        if (msg.length() > 250) {
                            System.out.println("Please enter a message of less than 50 characters.");
                            continue;
                        }

                        String id = String.valueOf(new Random().nextInt(899999999) + 100000000);
                        Message m = new Message(recipient, msg, id, i);
                        if (!m.checkRecipientCell()) {
                            System.out.println("Invalid phone number.");
                            continue;
                        }

                        m.messageHash = m.createMessageHash();
                        JOptionPane.showMessageDialog(null, m.sentMessage());
                    }
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Total messages sent: " + Message.returnTotalMessages());
    }
}
