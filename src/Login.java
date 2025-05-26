public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName) {   /* Joyce farrell, 2023 */
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) { /* Joyce farrell, 2023 */
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {   /* Joyce farrell, 2023 */
        return password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()].*") &&
               password.length() >= 8;
    }
}
