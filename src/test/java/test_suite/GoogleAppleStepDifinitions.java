package test_suite;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ui_model.page.result.AbstractGoogleResultPage;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by okunets on 22.03.2017.
 */
public class GoogleAppleStepDifinitions {
    private AbstractGoogleResultPage abstractGoogleResultPage;
    private List<Integer> resultLinkNumbers;

    public GoogleAppleStepDifinitions(CommonStepDefinitions definition) {
        this.abstractGoogleResultPage=definition.getAbstractGoogleResultPage();
        this.resultLinkNumbers=new  LinkedList<>();
    }

    @When("^I get the number of results$")
    public void i_get_the_number_of_results() throws Throwable {
      resultLinkNumbers.add(abstractGoogleResultPage.calculateResultsNumber());

    }

    @When("^I navigate to (\\d+) page$")
    public void i_navigete_to_nd_page(int number) throws Throwable {
        this.abstractGoogleResultPage = this.abstractGoogleResultPage.navigateToPageNumber(number);
    }

    @Then("^I check whether the number of results is the same on the above mentioned pages$")
    public void checkResultNumberEquality() throws Throwable {
        System.out.println(resultLinkNumbers);
        Assert.assertTrue(resultLinkNumbers.get(0).equals(resultLinkNumbers.get(1))&& resultLinkNumbers.get(1).equals(resultLinkNumbers.get(2)));
    }
}
