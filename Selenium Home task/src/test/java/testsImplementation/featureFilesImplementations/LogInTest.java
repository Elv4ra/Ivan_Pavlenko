package testsImplementation.featureFilesImplementations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import testsImplementation.browserFactory.BrowserFactory;
import testsImplementation.pageOM.BasePage;


public class LogInTest {
    private WebDriver driver;
    private BasePage pageOfTheSite;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User is at ([^\"]*) of the site in the ([^\"]*)$")
    public void userIsAtPageURLOfTheSiteInTheBrowser(String pageURL, String browserName) {
        this.setupDriver(browserName);
        this.pageOfTheSite = new BasePage(this.driver, pageURL);
    }

    @When("User clicks Log in button")
    public void userClicksButton() {
        this.pageOfTheSite.getLoginFrame();
    }

    @And("^types in username ([^\"]*)$")
    public void typesInUsernameUsername(String username) {
        this.pageOfTheSite.typeLoginUsername(username);
    }

    @And("^types in password ([^\"]*)$")
    public void typesInPasswordPassword(String password) {
        this.pageOfTheSite.typeLoginPassword(password);
    }

    @And("clicks Log in button")
    public void clicksButton() {
        this.pageOfTheSite.clickLogInButton();
    }

    @Then("^User must be logged in$")
    public void userMustBeLoggedInAtPageURL() {
        Assertions.assertTrue(this.pageOfTheSite.isLoggedIn());
        this.shutDownPage();
    }
}
