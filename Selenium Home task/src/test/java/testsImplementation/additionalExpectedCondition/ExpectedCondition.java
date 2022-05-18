package testsImplementation.additionalExpectedCondition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class ExpectedCondition {
    public static org.openqa.selenium.support.ui.ExpectedCondition<Boolean> waitForElementAnimationToFinish(final String cssSelector) {
        return new org.openqa.selenium.support.ui.ExpectedCondition<Boolean>() {
            private double x = 0;
            private double y = 0;
            private double width = 0;
            private double height = 0;

            private double convertToDouble(Object longValue) {
                if (longValue instanceof Long) {
                    return ((Long) longValue).doubleValue();
                }

                return (double) longValue;
            }

            @Override
            public Boolean apply(WebDriver driver) {
                WebElement elem = driver.findElement(By.cssSelector(cssSelector));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                Map<String, Object> rect = (Map<String, Object>) js.executeScript("var rect = arguments[0].getBoundingClientRect(); return { x: rect.x, y: rect.y, width: rect.width, height: rect.height };", elem);

                double newX = convertToDouble(rect.get("x"));
                double newY = convertToDouble(rect.get("y"));
                double newWidth = convertToDouble(rect.get("width"));
                double newHeight = convertToDouble(rect.get("height"));

                if (newX != x || newY != y || newWidth != width || newHeight != height) {
                    x = newX;
                    y = newY;
                    width = newWidth;
                    height = newHeight;
                    return false;
                }
                return true;
            }

            @Override
            public String toString() {
                return String.format("CSS Selector: \"%s\"", cssSelector);
            }
        };
    }
}
