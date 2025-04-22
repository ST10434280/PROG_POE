import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first name: "); /* Joyce farrell, 2023 */
        String fname = sc.nextLine();

        System.out.print("Enter your last name: ");/* Joyce farrell, 2023 */
        String lname = sc.nextLine();

        Login login = new Login(fname, lname);

        System.out.print("Enter username: ");/* Joyce farrell, 2023 */
        String username = sc.nextLine();

        System.out.print("Enter password: ");/* Joyce farrell, 2023 */
        String password = sc.nextLine();

        System.out.print("Enter phone number (with international code): ");/* Joyce farrell, 2023 */
        String cell = sc.nextLine();

        System.out.println(login.registerUser(username, password, cell));/* Joyce farrell, 2023 */

        System.out.println("Log in now:");/* Joyce farrell, 2023 */
        System.out.print("Username: ");
        String userLogin = sc.nextLine();

        System.out.print("Password: ");/* Joyce farrell, 2023 */
        String passLogin = sc.nextLine();

        boolean success = login.loginUser(userLogin, passLogin);
        System.out.println(login.returnLoginStatus(success));
    }
}
    
    

