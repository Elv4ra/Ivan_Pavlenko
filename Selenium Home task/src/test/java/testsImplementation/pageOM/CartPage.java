package testsImplementation.pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testsImplementation.additionalExpectedCondition.ExpectedCondition;

public class CartPage extends BasePage {
    private final By cartInfoContainer = By.id("page-wrapper");
    private final By placeOrderButton = By.cssSelector(".btn-success");
    private final By placeOrderFormFrame = By.id("orderModal");
    private final By formNameField = By.id("name");
    private final By formCountryField = By.id("country");
    private final By formCityField = By.id("city");
    private final By formCreditCardField = By.id("card");
    private final By formMonthField = By.id("month");
    private final By formYearField = By.id("year");
    private final By purchaseButton = By.cssSelector("#orderModal .btn-primary");
    private final By popUpFrame = By.className("sweet-alert");
    private final By popUpOkButton = By.cssSelector(".confirm");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void fillPlaceOrderForm(String name, String country, String city,
                                   String creditCard, String month, String year) {
        this.typeName(name)
                .typeCountry(country)
                .typeCity(city)
                .typeCreditCard(creditCard)
                .typeMonth(month)
                .typeYear(year)
                .clickPurchaseButton();
    }

    public void clickPlaceOrderButton() {
        super.waitVisibility(cartInfoContainer);
        super.waitAndClick(placeOrderButton);
    }

    public CartPage typeName(String name) {
        super.waitVisibility(formNameField);
        super.driver.findElement(formNameField).sendKeys(name);
        return this;
    }

    public CartPage typeCountry(String country) {
        super.waitVisibility(formCountryField);
        super.driver.findElement(formCountryField).sendKeys(country);
        return this;
    }

    public CartPage typeCity(String city) {
        super.waitVisibility(formCityField);
        super.driver.findElement(formCityField).sendKeys(city);
        return this;
    }

    public CartPage typeCreditCard(String creditCard) {
        super.waitVisibility(formCreditCardField);
        super.driver.findElement(formCreditCardField).sendKeys(creditCard);
        return this;
    }

    public CartPage typeMonth(String month) {
        super.waitVisibility(formMonthField);
        super.driver.findElement(formMonthField).sendKeys(month);
        return this;
    }

    public CartPage typeYear(String year) {
        super.waitVisibility(formYearField);
        super.driver.findElement(formYearField).sendKeys(year);
        return this;
    }

    public void clickPurchaseButton() {
        super.waitVisibility(placeOrderFormFrame);
        super.waitAndClick(purchaseButton);
    }

    public HomePage clickPopUpOkButton() {
        super.waitVisibility(popUpFrame);
        super.wait.until(ExpectedCondition.waitForElementAnimationToFinish(".sa-placeholder"));
        super.waitAndClick(popUpOkButton);
        return new HomePage(super.driver);
    }

    public boolean isPlaceOrderFromVisible() {
        super.waitVisibility(this.placeOrderFormFrame);
        return super.driver.findElement(this.placeOrderFormFrame).isDisplayed();
    }

    public boolean isPurchaseConfirmingWindowVisible() {
        super.waitVisibility(popUpFrame);
        return super.driver.findElement(popUpFrame).isDisplayed();
    }

    public boolean isPurchaseConfirmed() {
        super.wait.until(ExpectedCondition.waitForElementAnimationToFinish(".sa-placeholder"));
        return super.driver.findElement(By.cssSelector(".sa-placeholder")).isDisplayed();
    }
}


