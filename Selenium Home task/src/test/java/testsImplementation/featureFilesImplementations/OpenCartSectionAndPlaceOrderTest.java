package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.BasePage;
import testsImplementation.pageOM.CartPage;

public class OpenCartSectionAndPlaceOrderTest {
    private WebDriver driver;
    private BasePage basePage;
    private CartPage cartPage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User selected ([^\"]*) product in the ([^\"]*)$")
    public void userIsAtPageURLPageInTheFirefoxBrowser(String pageURL, String browserName) {
        this.setupDriver(browserName);
        this.basePage = new BasePage(this.driver, pageURL);
    }

    @When("^User clicks Cart button on the menu bar$")
    public void userClicksCartButtonOnTheMenuBar() {
        this.basePage.goToCartPage();
    }

    @Then("cart page opens with URL ([^\"]*)$")
    public void cartPageOpensWithURL(String URL) {
        Assertions.assertEquals(this.basePage.getPageURL(), URL);
        this.shutDownPage();
    }

    @Given("^User is at cart page using ([^\"]*)$")
    public void userIsAtCartPageUsingChrome(String browserName) {
        this.setupDriver(browserName);
        this.cartPage = new BasePage(this.driver, "https://www.demoblaze.com/").goToCartPage();
    }

    @When("User clicks Place Order button")
    public void userClicksPlaceOrderButton() {
        this.cartPage.clickPlaceOrderButton();
    }

    @Then("Place Order form appears")
    public void placeOrderFormAppears() {
        Assertions.assertTrue(this.cartPage.isPlaceOrderFromVisible());
        this.shutDownPage();
    }
}
