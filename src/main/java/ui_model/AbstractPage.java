package ui_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

/**
 * Created by okunets on 20.03.2017.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;

    }

    public GoogleHomePage navigateToHomePage() {
        driver.navigate().to(properties.getProperty("google_home_page"));
        return new GoogleHomePage(driver);
    }

//    public abstract AbstractPage click(WebElement element);

    public void close() {
        driver.close();
    }
}
