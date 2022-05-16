package pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private final By openLogInFrameButton = By.id("login2");
    private final By logInFrame = By.id("logInModal");
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By logInButton = By.cssSelector("#logInModal .btn-primary");
    private final By nameOfUser = By.id("nameofuser");
    private final By logOutButton = By.id("logout2");
    private final By productsRow = By.id("tbodyid");
    private final By categoriesList = By.className("list-group");

    public MainPage(WebDriver driver) {
        super(driver);
        super.driver.navigate().to("https://www.demoblaze.com/");
    }

    public void logIn(String username, String password) {
        this.getLoginFrame().typeLoginUsername(username).typeLoginPassword(password).clickLogInButton();
        super.wait.until(ExpectedConditions.invisibilityOfElementLocated(logInFrame));
    }

    public boolean isLoggedIn() {
        return super.driver.findElement(nameOfUser).isDisplayed();
    }

    public void logOut() {
        super.waitAndClick(logOutButton);
        super.waitVisibility(openLogInFrameButton);
    }

    public void selectCategory(String category) {
        super.waitVisibility(categoriesList);
        super.waitVisibility(productsRow);
        super.waitAndClick(By.linkText(category));
    }

    public ProductPage selectProduct(String product) {
        By productLocator = By.linkText(product);
        super.waitVisibility(productsRow);
        super.waitAndClick(productLocator);
        return new ProductPage(super.driver);
    }
    public void closePage() {
        super.driver.quit();
    }

    private MainPage getLoginFrame() {
        super.waitAndClick(openLogInFrameButton);
        return this;
    }

    private MainPage typeLoginUsername(String username) {
        super.waitVisibility(usernameField);
        super.driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    private MainPage typeLoginPassword(String password) {
        super.waitVisibility(passwordField);
        super.driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    private void clickLogInButton() {
        super.waitAndClick(logInButton);
    }
}
