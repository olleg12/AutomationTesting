package ui.model.page;

import factory.FirstResultPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Properties;

/**
 * Created by okunets on 20.03.2017.
 */
public abstract class AbstractPage {
    protected WebDriver driver;
    protected Properties properties;
    protected FirstResultPageFactory firstResultPageFactory;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.firstResultPageFactory=new FirstResultPageFactory(driver);
        wait = new WebDriverWait(driver, 5);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void close() {
        driver.close();
    }
}
