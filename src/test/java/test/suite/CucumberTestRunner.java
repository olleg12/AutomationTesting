package test.suite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by okunets on 21.03.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:target/cucumber.json"},
features = {"src\\main\\resources"})
public class CucumberTestRunner {
}
