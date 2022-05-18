package testsImplementation.pageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By productsRow = By.id("tbodyid");
    private final By categoriesList = By.className("list-group");

    public HomePage(WebDriver driver) {
        super(driver);
        super.driver.navigate().to("https://www.demoblaze.com/");
    }

    public void selectCategory(String category) {
        super.waitVisibility(categoriesList);
        super.waitVisibility(productsRow);
        super.waitAndClick(By.linkText(category));
    }

    public ProductPage selectProduct(String product) {
        super.waitVisibility(productsRow);
        By productLocator = By.linkText(product);
        super.waitAndClick(productLocator);
        return new ProductPage(super.driver);
    }
}
