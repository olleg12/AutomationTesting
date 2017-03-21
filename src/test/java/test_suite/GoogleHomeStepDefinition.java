package test_suite;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import ui_model.GoogleHomePage;

import java.io.*;
import java.util.Properties;

/**
 * Created by okunets on 21.03.2017.
 */
public class StepDefinitions {
    private GoogleHomePage googleHomePage;
    private Properties properties;
    InputStream inputStream;


    @Before
    public void setUp(){
        try {
            inputStream=new FileInputStream("src\\main\\resources\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties=new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(properties.getProperty("web_driver_property_type_of_driver"),
                properties.getProperty("web_driver_property_path_to_geckodriver"));
        WebDriver driver = new FirefoxDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.setProperties(properties);

        googleHomePage = googleHomePage.navigateToHomePage();
        WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
    }


    @When("^I enter \"([^\"]*)\" into searchfield$")
    public void i_enter_into_searchfield(String arg1) throws Throwable {
         this.googleHomePage.inputQuery(arg1);
    }

    @And("^I click on \"([^\"]*)\" button$")
    public void i_click_on_button(String arg1) throws Throwable {

    }

    @Then("^I check whether Showing results for translate\\.google\\.com is displayed$")
    public void i_check_whether_Showing_results_for_translate_google_com_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
