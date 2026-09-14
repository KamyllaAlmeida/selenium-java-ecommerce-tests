package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void shouldAddBackpackToCart() {
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();

        assertEquals("1", productsPage.getCartBadgeCount());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}