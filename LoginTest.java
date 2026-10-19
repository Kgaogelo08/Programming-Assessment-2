package quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUserNameCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27834557896");
        String result = login.checkUserName();
        assertEquals("Username successfully captured.", result);
    }

    @Test
    public void testUserNameIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27834557896");
        String result = login.checkUserName();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27834557896");
        String result = login.checkPasswordComplexity();
        assertEquals("Password successfully captured.", result);
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "password", "+27834557896");
        String result = login.checkPasswordComplexity();
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27834557896");
        String result = login.checkCellPhoneNumber();
        assertEquals("Cell phone number successfully added.", result);
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        String result = login.checkCellPhoneNumber();
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27834557896");
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27834557896");
        boolean result = login.loginUser("kyl_1", "wrongPass");
        assertFalse(result);
    }
}