package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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