import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordFailsComplexity() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccess() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailure() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "pass"));
    }

    @Test
    public void testReturnWelcomeMessage() {
        Login login = new Login("Kyle", "Smith");
        String expected = "Welcome Kyle Smith, it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginFailureMessage() {
        Login login = new Login("Kyle", "Smith");
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus(false));
    }
}

/* Please note that i was unable to install the gradle support plugin shown in the video provided. however i have run the required tests through the above code.
