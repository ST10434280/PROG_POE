import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkUserName("kyl_1"));
    }

    
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    
    public void testPasswordFailsComplexity() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    
    public void testLoginSuccess() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    
    public void testLoginFailure() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "pass"));
    }

    
    public void testReturnWelcomeMessage() {
        Login login = new Login("Kyle", "Smith");
        String expected = "Welcome Kyle Smith, it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus(true));
    }

    
    public void testReturnLoginFailureMessage() {
        Login login = new Login("Kyle", "Smith");
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus(false));
    }
}

/* Please note that i was unable to install the gradle support plugin shown in the video provided. however i have run the required tests through the above code.
