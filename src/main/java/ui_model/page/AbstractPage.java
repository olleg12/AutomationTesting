package ui_model.page;

import factory.FirstResultPageFactory;
import org.openqa.selenium.WebDriver;
import ui_model.page.GoogleHomePage;

import java.util.Properties;

/**
 * Created by okunets on 20.03.2017.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected Properties properties;
    protected FirstResultPageFactory firstResultPageFactory;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.firstResultPageFactory=new FirstResultPageFactory(driver);
    }





    public void close() {
        driver.close();
    }
}
