package ui.model.page.result.first;

import org.openqa.selenium.WebDriver;
import ui.model.page.GoogleTranslatePage;
import ui.model.page.result.AbstractGoogleResultPage;

/**
 * Created by okunets on 22.03.2017.
 */
public class FirstGoogleResultPageTranslate extends FirstGoogleResultPage {
    public FirstGoogleResultPageTranslate(WebDriver driver) {
        super(driver);
    }

    @Override
    public int calculateResultsNumber() {
        return 0;
    }

    @Override
    public AbstractGoogleResultPage navigateToPageNumber(int number) {
        return null;
    }


    //todo replace multiple concrete methods with the absrtact one returning generic type
    public GoogleTranslatePage clickOnFirstLink() {
        navigateToFirstLink();
        GoogleTranslatePage translatePage=new GoogleTranslatePage(driver);
        translatePage.setProperties(properties);
        return translatePage;

    }
}
