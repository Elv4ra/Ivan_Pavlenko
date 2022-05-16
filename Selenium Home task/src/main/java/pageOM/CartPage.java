package pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageOM.additionalExpectedCondition.ExpectedCondition.waitForElementAnimationToFinish;

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

    public MainPage placeOrder(String name, String country, String city,
                           String creditCard, String month, String year) {
        return this.clickPlaceOrderButton()
                .fillPlaceOrderForm(name, country, city, creditCard,  month, year)
                .clickPurchaseButton()
                .clickPopUpOkButton();
    }

    private CartPage fillPlaceOrderForm(String name, String country, String city,
                                        String creditCard, String month, String year) {
        this.typeName(name)
                .typeCountry(country)
                .typeCity(city)
                .typeCreditCard(creditCard)
                .typeMonth(month)
                .typeYear(year);
        return this;
    }

    private CartPage clickPlaceOrderButton() {
        super.waitVisibility(cartInfoContainer);
        super.waitAndClick(placeOrderButton);
        return this;
    }

    private CartPage typeName(String name) {
        super.waitVisibility(formNameField);
        super.driver.findElement(formNameField).sendKeys(name);
        return this;
    }

    private CartPage typeCountry(String country) {
        super.waitVisibility(formCountryField);
        super.driver.findElement(formCountryField).sendKeys(country);
        return this;
    }

    private CartPage typeCity(String city) {
        super.waitVisibility(formCityField);
        super.driver.findElement(formCityField).sendKeys(city);
        return this;
    }

    private CartPage typeCreditCard(String creditCard) {
        super.waitVisibility(formCreditCardField);
        super.driver.findElement(formCreditCardField).sendKeys(creditCard);
        return this;
    }

    private CartPage typeMonth(String month) {
        super.waitVisibility(formMonthField);
        super.driver.findElement(formMonthField).sendKeys(month);
        return this;
    }

    private CartPage typeYear(String year) {
        super.waitVisibility(formYearField);
        super.driver.findElement(formYearField).sendKeys(year);
        return this;
    }

    private CartPage clickPurchaseButton() {
        super.waitVisibility(placeOrderFormFrame);
        super.waitAndClick(purchaseButton);
        return this;
    }

    private MainPage clickPopUpOkButton() {
        super.waitVisibility(popUpFrame);
        super.wait.until(waitForElementAnimationToFinish(".sa-placeholder"));
        super.waitAndClick(popUpOkButton);
        return new MainPage(super.driver);
    }
}


