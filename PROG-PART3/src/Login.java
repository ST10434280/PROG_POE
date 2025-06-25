import java.util.regex.*;

public class Login {
    private String username;
    private String password;
    private String phone;

    public Login(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

    public boolean checkCellPhoneNumber() {
        return phone.matches("^\\+[0-9]{9,10}$");
    }

    public String registerUser() {
        if (!checkUserName())
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        if (!checkPasswordComplexity())
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        if (!checkCellPhoneNumber())
            return "Cell number is incorrectly formatted or does not contain international code, please correct the number and try again.";
        return "Registration successful.";
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public String returnLoginStatus(boolean loggedIn, String firstName, String lastName) {
        return loggedIn ?
               "Welcome " + firstName + "," + lastName + " it is great to see you." :
               "Username or password incorrect, please try again.";
    }
}

