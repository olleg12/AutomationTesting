package test.suite;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.model.page.GoogleHomePage;
import ui.model.page.result.AbstractGoogleResultPage;

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
        driver = new FirefoxDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage = googleHomePage.navigateToHomePage();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }



    @When("^I enter \"([^\"]*)\" into searchfield$")
    public void enterQuery(String query) throws Throwable {
        googleHomePage.inputQuery(query);
    }

    @And("^I click on Google Search button$")
    public void clickSearchButton() throws Throwable {
        abstractGoogleResultPage = googleHomePage.clickSearchButton();
    }
}
