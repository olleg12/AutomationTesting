package test.suite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.model.page.result.AbstractGoogleResultPage;
import ui.model.page.GoogleTranslatePage;
import ui.model.page.result.first.FirstGoogleResultPageTranslate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleTranslateStepDefinitions {
    private AbstractGoogleResultPage abstractGoogleResultPage;
    private GoogleTranslatePage googleTranslatePage;
    private String previousTranslation;

    public GoogleTranslateStepDefinitions(CommonStepDefinitions definition) {
        this.abstractGoogleResultPage = definition.getAbstractGoogleResultPage();
    }

    @When("^I fill translate from field$")
    public void fillInTranslateFromField() throws Throwable {
        googleTranslatePage.inputApple();
    }

    @When("^I save the previous translation$")
    public void savePreviousTranslation() throws Throwable {
        previousTranslation = googleTranslatePage.getTranslation();
    }


    @Then("^I compare the translations$")
    public void compareTranslations() throws Throwable {
        assertFalse(previousTranslation.equals(googleTranslatePage.getTranslation()));
    }

    @And("^I click on the first link$")
    public void iClickOnTheFirstLink() throws Throwable {
        if (abstractGoogleResultPage instanceof FirstGoogleResultPageTranslate) {
            FirstGoogleResultPageTranslate firstGoogleResultPageTranslate = (FirstGoogleResultPageTranslate) this.abstractGoogleResultPage;
            googleTranslatePage = firstGoogleResultPageTranslate.clickOnFirstLink();
        }
    }

    @And("^I choose the language to translate in$")
    public void iChooseTheLanguageToTranslateIn() throws Throwable {
        googleTranslatePage.chooseLanguageToTranslateIn();
    }
}
