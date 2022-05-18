package testsImplementation.pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final By addToCartButton = By.linkText("Add to cart");
    private final By productInfoContainer = By.className("product-content");
    private final By productNameField = By.className("name");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage(WebDriver driver, String productPageURL) {
        super(driver);
        super.driver.navigate().to(productPageURL);
    }

    public String getProductName() {
        super.waitVisibility(productNameField);
        return super.driver.findElement(productNameField).getText();
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

    public boolean isProductAddingSuccessful() {
        return super.driver.getCurrentUrl().contains("#");
    }
}
