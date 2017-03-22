package ui_model.page.result.other;

import org.openqa.selenium.WebDriver;
import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.result.first.FirstGoogleResultPageApple;

/**
 * Created by okunets on 22.03.2017.
 */
public class OtherGoogleResultPageApple extends OtherGoogleResultPage {
    public OtherGoogleResultPageApple(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractGoogleResultPage navigateToPageNumber(int number) {
//        if (pageNumber==number){
//            return this;
//        }
//        else
            if (number==1){
            return new FirstGoogleResultPageApple(driver);
        }
        return this;
    }

    @Override
    public int calculateResultsNumber() {
        return resultLinks.size();
    }
}
