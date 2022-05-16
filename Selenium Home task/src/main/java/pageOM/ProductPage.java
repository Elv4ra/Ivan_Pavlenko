package pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final By addToCartButton = By.linkText("Add to cart");
    private final By productInfoContainer = By.className("product-content");
    private final By goToCartButton = By.id("cartur");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        super.waitVisibility(productInfoContainer);
        super.waitAndClick(addToCartButton);
        this.alertAccepting();
    }

    private void alertAccepting() {
        super.wait.until(ExpectedConditions.alertIsPresent());
        super.driver.switchTo().alert().accept();
    }

    public CartPage goToCartPage() {
        super.waitVisibility(goToCartButton);
        super.waitAndClick(goToCartButton);
        return new CartPage(super.driver);
    }
}
