package ui_model.page.result.other;

import org.openqa.selenium.WebDriver;
import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.result.first.FirstGoogleResultPageTranslate;

/**
 * Created by okunets on 22.03.2017.
 */
public class OtherGoogleResultPageTranslate extends OtherGoogleResultPage {
    public OtherGoogleResultPageTranslate(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractGoogleResultPage navigateToPageNumber(int number) {
        if (pageNumber==number)
            return this;
        else if (number==1){
            return new FirstGoogleResultPageTranslate(driver);
        }
        return this;
    }

    @Override
    public int calculateResultsNumber() {
        return 0;
    }
}
