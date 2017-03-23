package test_suite;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.GoogleHomePage;

import static org.junit.Assert.assertTrue;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleHomeStepDefinition {
    private AbstractGoogleResultPage abstractGoogleResultPage;

    public GoogleHomeStepDefinition(CommonStepDefinitions commonStepDefinitions){
        this.abstractGoogleResultPage=commonStepDefinitions.getAbstractGoogleResultPage();
    }

    @Then("^I check whether Showing results for translate\\.google\\.com is displayed$")
    public void i_check_whether_Showing_results_for_translate_google_com_is_displayed() throws Throwable {
        System.out.println(abstractGoogleResultPage.getValueOfShowingResultsFor());
        assertTrue(abstractGoogleResultPage.getValueOfShowingResultsFor().equals(abstractGoogleResultPage.getProperties().getProperty("expected_result_string")));

    }

}
