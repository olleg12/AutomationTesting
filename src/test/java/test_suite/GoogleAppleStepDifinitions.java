package test_suite;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui_model.page.GoogleHomePage;
import ui_model.page.result.AbstractGoogleResultPage;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by okunets on 22.03.2017.
 */
public class GoogleAppleStepDifinitions {
    private GoogleHomeStepDefinition definition;
    private GoogleHomePage googleHomePage;
    private AbstractGoogleResultPage abstractGoogleResultPage;
    private List<Integer> resultLinkNumbers;

    public GoogleAppleStepDifinitions(GoogleHomeStepDefinition definition) {
        this.definition = definition;
        this.abstractGoogleResultPage=definition.getAbstractGoogleResultPage();
        this.resultLinkNumbers=new  LinkedList<>();
    }

    @When("^I get the number of results$")
    public void i_get_the_number_of_results() throws Throwable {
      resultLinkNumbers.add(abstractGoogleResultPage.calculateResultsNumber());

    }

    @When("^I navigate to (\\d+) page$")
    public void i_navigete_to_nd_page(int number) throws Throwable {
        AbstractGoogleResultPage abstractGoogleResultPage = this.abstractGoogleResultPage.navigateToPageNumber(number);
    }

    @Then("^I check whether the number of results is the same on the above mentioned pages$")
    public void i_check_whether_the_number_of_results_is_the_same_on_the_above_mentioned_pages() throws Throwable {
        System.out.println(resultLinkNumbers);
    }
}
