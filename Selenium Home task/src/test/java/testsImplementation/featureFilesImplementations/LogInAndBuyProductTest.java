package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.BasePage;
import testsImplementation.pageOM.CartPage;
import testsImplementation.pageOM.HomePage;
import testsImplementation.pageOM.ProductPage;

public class LogInAndBuyProductTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private BasePage finalPage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User is at the main page in the ([^\"]*)$")
    public void userIsAtTheMainPageInTheBrowser(String browserName) {
        this.setupDriver(browserName);
        this.homePage = new HomePage(this.driver);
    }

    @When("^User logs in with credentials ([^\"]*) and ([^\"]*)$")
    public void userLogsInWithCredentials(String username, String password) {
        this.homePage.logIn(username, password);
    }

    @And("^selects ([^\"]*) category$")
    public void selectsCategoryCategory(String category) {
        this.homePage.selectCategory(category);
    }

    @And("^selects product ([^\"]*)$")
    public void selectsProduct(String product) {
        this.productPage = this.homePage.selectProduct(product);
    }

    @And("adds it to the cart")
    public void addsItToTheCart() {
        this.productPage.addProductToCart();
    }

    @And("opens cart section")
    public void opensCartSection() {
        this.cartPage = productPage.goToCartPage();
    }

    @And("clicks Place Order button")
    public void clicksPlaceOrderButton() {
        this.cartPage.clickPlaceOrderButton();
    }

    @And("^fills up form with data ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*)$")
    public void fillsUpForm(String name, String country, String city,
                            String creditCard, String month, String year) {
        this.cartPage.fillPlaceOrderForm(name, country, city,
                creditCard, month, year);
    }

    @And("purchases product")
    public void purchasesProduct() {
        this.cartPage.clickPurchaseButton();
    }

    @And("clicks OK button after receiving confirmation")
    public void clicksOKButton() {
        this.finalPage = this.cartPage.clickPopUpOkButton();
    }

    @Then("site is redirected back to the Home page")
    public void siteIsRedirectedBackToTheHomePage() {
        Assertions.assertTrue(this.finalPage instanceof HomePage);
        this.shutDownPage();
    }
}
