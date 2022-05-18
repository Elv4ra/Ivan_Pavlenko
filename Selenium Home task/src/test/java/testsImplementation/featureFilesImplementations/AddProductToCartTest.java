package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.ProductPage;

public class AddProductToCartTest {
    private WebDriver driver;
    private ProductPage productPage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User is at ([^\"]*) product page in the browser ([^\"]*)$")
    public void userIsAtTheSelectedProductPageInTheBrowser(String productPageURL, String browserName) {
        this.setupDriver(browserName);
        this.productPage = new ProductPage(this.driver, productPageURL);
    }

    @When("User clicks Add to cart button")
    public void userClicksAddToCartButton() {
        this.productPage.addProductToCart();
    }

    @Then("alert about adding the product to the cart appears")
    public void alertAboutAddingTheProductToTheCartAppears() {
        Assertions.assertTrue(this.productPage.isProductAddingSuccessful());
        this.shutDownPage();
    }
}
