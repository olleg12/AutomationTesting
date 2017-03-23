package ui.model.page.result.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.model.page.result.AbstractGoogleResultPage;
import ui.model.page.result.first.FirstGoogleResultPageApple;


/**
 * Created by okunets on 22.03.2017.
 */
public class OtherGoogleResultPageApple extends OtherGoogleResultPage {

    public OtherGoogleResultPageApple(WebDriver driver) {
        super(driver);
    }
    @Override
    public AbstractGoogleResultPage navigateToPageNumber(int number) {
            if (number==1){
            return new FirstGoogleResultPageApple(driver);
        }
        return this;
    }

    @Override
    public int calculateResultsNumber() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".rc>.r>a"),6));
        return  resultLinks.size();
    }
}
