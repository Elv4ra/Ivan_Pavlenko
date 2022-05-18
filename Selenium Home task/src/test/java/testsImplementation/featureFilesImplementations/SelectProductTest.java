package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.HomePage;
import testsImplementation.pageOM.ProductPage;

public class SelectProductTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User is at Home Page in the ([^\"]*) browser$")
    public void userIsAtHomePageInTheBrowser(String browserName) {
        this.setupDriver(browserName);
        this.homePage = new HomePage(this.driver);
    }

    @Given("^User selects the ([^\"]*) category button$")
    public void userSelectsTheCategoryButton(String category) {
        this.homePage.selectCategory(category);
    }

    @When("^User clicks on the ([^\"]*) product title$")
    public void userClicksOnTheNameProductTitle(String productName) {
        this.productPage = this.homePage.selectProduct(productName);
    }

    @Then("^page of ([^\"]*) product opens$")
    public void pageOfNameProductOpens(String productName) {
        Assertions.assertEquals(productName, this.productPage.getProductName());
        this.shutDownPage();
    }
}
