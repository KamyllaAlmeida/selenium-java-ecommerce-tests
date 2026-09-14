package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    void initializeLoginPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    void shouldLoginSuccessfullyWithValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "User should be redirected to the inventory page"
        );
    }

    @Test
    void shouldDisplayErrorForInvalidPassword() {
        loginPage.login("standard_user", "wrong_password");

        assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "An error message should be displayed for an invalid password"
        );
    }
}