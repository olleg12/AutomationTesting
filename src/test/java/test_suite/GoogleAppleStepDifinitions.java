package test_suite;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui_model.GoogleHomePage;

/**
 * Created by okunets on 22.03.2017.
 */
public class GoogleAppleStepDifinitions {
    private GoogleHomeStepDefinition definition;
    private GoogleHomePage googleHomePage;
    public GoogleAppleStepDifinitions(GoogleHomeStepDefinition definition) {
        this.definition = definition;
//        this.googleHomePage=definition.getGoogleHomePage();
    }




    @When("^I get the number of results$")
    public void i_get_the_number_of_results() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I navigate to (\\d+) page$")
    public void i_navigete_to_nd_page(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I check whether the number of results is the same on the above mentioned pages$")
    public void i_check_whether_the_number_of_results_is_the_same_on_the_above_mentioned_pages() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
