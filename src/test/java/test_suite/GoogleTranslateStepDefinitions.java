package test_suite;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui_model.GoogleHomePage;
import ui_model.GoogleResultPage;
import ui_model.GoogleTranslatePage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleTranslateStepDefinitions {
    private GoogleResultPage googleResultPage;
    private GoogleTranslatePage googleTranslatePage;
    private GoogleHomeStepDefinition definition;
    private String previousTranslation;

    public GoogleTranslateStepDefinitions(GoogleHomeStepDefinition definition) {
        this.definition = definition;
        this.googleResultPage=definition.getGoogleResultPage();
    }

    @When("^I fill in first field Apple$")
    public void i_fill_in_first_field_Apple() throws Throwable {
         googleTranslatePage.inputApple();
    }

    @When("^I save the previous translation$")
    public void i_save_the_previous_translation() throws Throwable {
        previousTranslation=googleTranslatePage.getTranslation();
    }



    @Then("^I compare the translations$")
    public void i_compare_the_translations() throws Throwable {
        assertFalse(previousTranslation.equals(googleTranslatePage.getTranslation()));
    }

    @And("^I click on the first link$")
    public void iClickOnTheFirstLink() throws Throwable {
        googleTranslatePage = googleResultPage.clickOnGoogleTranslateLink();
    }

    @And("^I click on languages dropdown$")
    public void iClickOnLanguagesDropdown() throws Throwable {
        googleTranslatePage.clickOnLanguagesDropdown();
    }

    @And("^I choose the language to translate in$")
    public void iChooseTheLanguageToTranslateIn() throws Throwable {
     googleTranslatePage.chooseLanguageToTranslateIn();
    }
}
