package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.CartPage;
import testsImplementation.pageOM.ProductPage;

public class ConfirmingPurchaseTest {
    private WebDriver driver;
    private ProductPage productPage;
    private CartPage cartPage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User adds product ([^\"]*) to the cart using ([^\"]*) browser$")
    public void userAddsProductProductURLToTheCart(String productURL, String browserName) {
        this.setupDriver(browserName);
        this.productPage = new ProductPage(this.driver, productURL);
        this.productPage.addProductToCart();
    }

    @And("click Cart button to open cart section")
    public void clickCartButtonToOpenCartSection() {
        this.cartPage = this.productPage.goToCartPage();
    }

    @When("User places order")
    public void userPlacesOrder() {
        this.cartPage.clickPlaceOrderButton();
    }

    @And("^fills up form with information ([^\"]*), ([^\"]*)," +
            "([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*)")
    public void fillsUpFormWithInformation(String name, String country, String city,
                                           String creditCard, String month, String year) {
        this.cartPage.fillPlaceOrderForm(name, country, city, creditCard, month, year);
    }

    @And("clicks button Purchase")
    public void clicksButtonPurchase() {
        this.cartPage.clickPurchaseButton();
    }

    @Then("purchase must be confirmed")
    public void purchaseMustBeConfirmed() {
        Assertions.assertTrue(this.cartPage.isPurchaseConfirmed());
        this.shutDownPage();
    }
}
