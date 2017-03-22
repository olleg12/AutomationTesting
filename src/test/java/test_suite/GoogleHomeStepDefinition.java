package test_suite;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.GoogleHomePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleHomeStepDefinition {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private AbstractGoogleResultPage abstractGoogleResultPage;
    private Properties properties;
    private InputStream inputStream;

    public AbstractGoogleResultPage getAbstractGoogleResultPage() {
        return abstractGoogleResultPage;
    }

    public void setAbstractGoogleResultPage(AbstractGoogleResultPage abstractGoogleResultPage) {
        this.abstractGoogleResultPage = abstractGoogleResultPage;
    }




    @Before
    public void setUp() {
        try {
            inputStream = new FileInputStream("src\\main\\resources\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.setProperty(properties.getProperty("web_driver_property_type_of_driver"),
//                properties.getProperty("web_driver_property_path_to_geckodriver"));
        driver = new FirefoxDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.setProperties(properties);
        googleHomePage = googleHomePage.navigateToHomePage();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }


    @When("^I enter \"([^\"]*)\" into searchfield$")
    public void i_enter_into_searchfield(String arg1) throws Throwable {
        googleHomePage.inputQuery(arg1);
    }

    @And("^I click on \"([^\"]*)\" button$")
    public void i_click_on_button(String arg1) throws Throwable {
        abstractGoogleResultPage = googleHomePage.clickSearchButton();
        abstractGoogleResultPage.setProperties(properties);
    }

    @Then("^I check whether Showing results for translate\\.google\\.com is displayed$")
    public void i_check_whether_Showing_results_for_translate_google_com_is_displayed() throws Throwable {
        System.out.println(abstractGoogleResultPage.getValueOfShowingResultsFor());
        assertTrue(abstractGoogleResultPage.getValueOfShowingResultsFor().equals(properties.getProperty("expected_result_string")));

    }

}
