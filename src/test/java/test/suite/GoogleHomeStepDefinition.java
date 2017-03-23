package test.suite;

import cucumber.api.java.en.Then;
import ui.model.page.result.AbstractGoogleResultPage;

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
        assertTrue(abstractGoogleResultPage.getValueOfShowingResultsFor().equals("Showing results for translate.google.com"));
    }

}
