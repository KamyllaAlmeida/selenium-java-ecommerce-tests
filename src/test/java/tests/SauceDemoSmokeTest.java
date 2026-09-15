package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SauceDemoSmokeTest extends BaseTest {

    @Test
    void shouldOpenSauceDemo() {
        assertEquals(
                "Swag Labs",
                driver.getTitle(),
                "The SauceDemo page title should be Swag Labs"
        );
    }
}