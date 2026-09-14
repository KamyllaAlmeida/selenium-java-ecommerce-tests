package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    void initializePages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    void shouldAddBackpackToCart() {
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();

        assertEquals(
                "1",
                productsPage.getCartBadgeCount(),
                "The cart badge should display one item"
        );
    }
}