package ui_model.page.result.first;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui_model.page.GoogleTranslatePage;
import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.result.other.OtherGoogleResultPageTranslate;

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
        throw new NotImplementedException();
    }



    public GoogleTranslatePage clickOnFirstLink() {
        navigateToFirstLink();
        GoogleTranslatePage translatePage=new GoogleTranslatePage(driver);
        translatePage.setProperties(properties);
        return translatePage;

    }
}
