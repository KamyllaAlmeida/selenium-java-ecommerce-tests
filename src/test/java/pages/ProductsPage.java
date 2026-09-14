package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private final WebDriver driver;

    private final By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By cartBadge =
            By.cssSelector("[data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }
}