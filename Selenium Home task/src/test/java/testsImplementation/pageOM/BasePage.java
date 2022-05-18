package testsImplementation.pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //Page created for navigation bar manipulations
    protected final By openLogInFrameButton = By.id("login2");
    protected final By logInFrame = By.id("logInModal");
    protected final By usernameField = By.id("loginusername");
    protected final By passwordField = By.id("loginpassword");
    protected final By logInButton = By.cssSelector("#logInModal .btn-primary");
    protected final By nameOfUser = By.id("nameofuser");
    private final By goToCartButton = By.id("cartur");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public BasePage(WebDriver driver, String pageURL) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.driver.navigate().to(pageURL);
    }

    public String getPageURL() {
        return this.driver.getCurrentUrl();
    }

    public void logIn(String username, String password) {
        this.getLoginFrame().typeLoginUsername(username).typeLoginPassword(password).clickLogInButton();
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(logInFrame));
    }

    public boolean isLoggedIn() {
        this.waitVisibility(nameOfUser);
        return this.driver.findElement(nameOfUser).isDisplayed();
    }

    public BasePage getLoginFrame() {
        this.waitAndClick(openLogInFrameButton);
        return this;
    }

    public BasePage typeLoginPassword(String password) {
        this.waitVisibility(passwordField);
        this.driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public BasePage typeLoginUsername(String username) {
        this.waitVisibility(usernameField);
        this.driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public void clickLogInButton() {
        this.waitAndClick(logInButton);
    }

    public CartPage goToCartPage() {
        this.waitVisibility(goToCartButton);
        this.waitAndClick(goToCartButton);
        return new CartPage(this.driver);
    }

    protected void waitAndClick(By locator) {
        this.wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void waitVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
