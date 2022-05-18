package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.HomePage;

public class SelectCategoryTest {
    private WebDriver driver;
    private HomePage homePage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User is at Home Page using ([^\"]*)$")
    public void userIsAtPageURLOfTheSiteInTheBrowser(String browserName) {
        this.setupDriver(browserName);
        this.homePage = new HomePage(this.driver);
    }

    @When("^User clicks on the ([^\"]*) category button$")
    public void userClicksOnTheCategoryButton(String category) {
        this.homePage.selectCategory(category);
    }

    @Then("products on the home page must be changed")
    public void productsOnTheHomePageMustBeChanged() {
        Assertions.assertTrue(this.homePage.getPageURL().contains("#"));
        this.shutDownPage();
    }
}
