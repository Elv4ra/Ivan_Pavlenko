package TestsImplementations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenURLTest {
    private WebDriver driver;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }


    @Given("^User is at \"([^\"]*)\"$")
    public void userIsAtHttpsWwwGoogleCom(String startLink) {
        driver.navigate().to(startLink);
    }

    @When("^User types into search field \"([^\"]*)\"$")
    public void userTypesIntoSearchFieldLink(String link) {
        driver.navigate().to(link);
    }

    @Then("^current page link must be \"([^\"]*)\"$")
    public void currentPageLinkMustBeLink(String link) {
        Assertions.assertEquals(link, driver.getCurrentUrl());
        driver.quit();
    }
}
