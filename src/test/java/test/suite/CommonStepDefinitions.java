package test.suite;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.model.page.GoogleHomePage;
import ui.model.page.result.AbstractGoogleResultPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by okunets on 23.03.2017.
 */
public class CommonStepDefinitions {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private AbstractGoogleResultPage abstractGoogleResultPage;

    public AbstractGoogleResultPage getAbstractGoogleResultPage() {
        return abstractGoogleResultPage;
    }

    @Before
    public void setUp() {
        InputStream propertiesFile = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new FirefoxDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.setProperties(properties);
        googleHomePage = googleHomePage.navigateToHomePage();
    }

    @After
    public void closeBrowser() {
        abstractGoogleResultPage.close();
    }



    @When("^I enter \"([^\"]*)\" into searchfield$")
    public void enterQuery(String query) throws Throwable {
        googleHomePage.inputQuery(query);
    }

    @And("^I click on Google Search button$")
    public void clickSearchButton() throws Throwable {
        abstractGoogleResultPage = googleHomePage.clickSearchButton();
        abstractGoogleResultPage.setProperties(googleHomePage.getProperties());
    }
}
