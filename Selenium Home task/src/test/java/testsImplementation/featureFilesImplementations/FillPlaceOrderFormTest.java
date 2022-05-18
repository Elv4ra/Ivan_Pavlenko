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

public class FillPlaceOrderFormTest {
    private WebDriver driver;
    private CartPage cartPage;

    private void setupDriver(String browserName) {
        this.driver = BrowserFactory.getBrowser(browserName);
    }

    public void shutDownPage() {
        this.driver.quit();
    }

    @Given("^User is at cart page and Place Order form is opened in the ([^\"]*) browser$")
    public void userIsAtCartPageAndPlaceOrderFormIsOpenedInTheBrowser(String browserName) {
        this.setupDriver(browserName);
        this.cartPage = new BasePage(this.driver, "https://www.demoblaze.com/").goToCartPage();
        this.cartPage.clickPlaceOrderButton();
    }

    @When("^User types in name field ([^\"]*)$")
    public void userTypesInNameFieldName(String name) {
        this.cartPage.typeName(name);
    }

    @And("^types in country field ([^\"]*)$")
    public void typesInCountryFieldCountry(String country) {
        this.cartPage.typeCountry(country);
    }

    @And("^types in city field ([^\"]*)$")
    public void typesInCityFieldCity(String city) {
        this.cartPage.typeCreditCard(city);
    }

    @And("^types in credit card field ([^\"]*)$")
    public void typesInCreditCardFieldCreditCard(String creditCard) {
        this.cartPage.typeCreditCard(creditCard);
    }

    @And("^types in month field ([^\"]*)$")
    public void typesInMonthFieldMonth(String month) {
        this.cartPage.typeMonth(month);
    }

    @And("^types in year field ([^\"]*)$")
    public void typesInYearFieldYear(String year) {
        this.cartPage.typeYear(year);
    }

    @And("clicks Purchase button")
    public void clicksPurchaseButton() {
        this.cartPage.clickPurchaseButton();
    }

    @Then("confirming window appears")
    public void confirmingWindowAppears() {
        Assertions.assertTrue(this.cartPage.isPurchaseConfirmingWindowVisible());
        this.shutDownPage();
    }
}
