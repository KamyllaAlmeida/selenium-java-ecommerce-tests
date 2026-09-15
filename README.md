# Selenium Java E-Commerce Tests

![Selenium Tests](https://github.com/KamyllaAlmeida/selenium-java-ecommerce-tests/actions/workflows/tests.yml/badge.svg)

Automated UI testing project created to demonstrate web test automation practices using Java, Selenium WebDriver, JUnit 5, Maven, and GitHub Actions.

The tests run against [SauceDemo](https://www.saucedemo.com/), a sample e-commerce website designed for automation practice.

## Technologies

- Java 17
- Selenium WebDriver
- JUnit 5
- Maven
- Page Object Model
- Git and GitHub
- GitHub Actions

## Automated Test Scenarios

### Smoke Test

- Verify that the SauceDemo website opens successfully.
- Verify that the page title is `Swag Labs`.

### Login Tests

- Login successfully with valid credentials.
- Display an error message when an invalid password is entered.

### Cart Test

- Login with valid credentials.
- Add the Sauce Labs Backpack to the cart.
- Verify that the cart badge displays one item.

## Project Structure

```text
src/test/java
├── pages
│   ├── LoginPage.java
│   └── ProductsPage.java
└── tests
    ├── BaseTest.java
    ├── SauceDemoSmokeTest.java
    ├── LoginTest.java
    └── CartTest.java
```

## Test Design

The project uses the Page Object Model to separate page interactions from test scenarios.

- `LoginPage` contains the elements and actions related to login.
- `ProductsPage` contains the elements and actions related to products and the shopping cart.
- `BaseTest` provides shared browser setup and teardown.
- Test classes contain the scenarios and assertions.

Explicit waits are used to improve test reliability and reduce synchronization problems.

## Running the Tests

### Using Maven

From the project directory, run:

```bash
mvn test
```

### Using IntelliJ IDEA

1. Open the Maven tool window.
2. Expand `Lifecycle`.
3. Double-click `test`.

## Continuous Integration

GitHub Actions automatically runs the complete test suite:

- When a pull request targets the `main` branch.
- When changes are pushed to the `main` branch.

Tests run with Chrome in headless mode inside the CI environment.

The workflow is located at:

```text
.github/workflows/tests.yml
```

## Future Improvements

- Add tests for removing products from the cart.
- Add checkout flow tests.
- Add data-driven tests.
- Add screenshots when tests fail.
- Generate automated test reports.
- Support multiple browsers.

## Author

Kamylla Florencio de Almeida
