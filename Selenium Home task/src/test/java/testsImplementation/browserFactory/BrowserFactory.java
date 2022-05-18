package testsImplementation.browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName) {
        if (browserName.compareToIgnoreCase("firefox") >= 0 ||
        browserName.compareToIgnoreCase("mozilla") >= 0) return getFirefoxBrowserDriver();
        else if (browserName.compareToIgnoreCase("edge") >= 0) return getEdgeBrowserDriver();
        else if (browserName.compareToIgnoreCase("opera") >= 0) return getOperaBrowserDriver();
        else if (browserName.compareToIgnoreCase("safari") >= 0) return getSafariBrowserDriver();
        else return getChromeBrowserDriver();
    }

    private static WebDriver getChromeBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxBrowserDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getEdgeBrowserDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver getOperaBrowserDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    private static WebDriver getSafariBrowserDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }
}