package ui.model.page.result.first;

import org.openqa.selenium.WebDriver;
import ui.model.page.AbstractPage;
import ui.model.page.GoogleHomePage;
import ui.model.page.result.AbstractGoogleResultPage;

/**
 * Created by okunets on 22.03.2017.
 */
public abstract class FirstGoogleResultPage<T extends AbstractPage> extends AbstractGoogleResultPage {
    public FirstGoogleResultPage(WebDriver driver) {
        super(driver);
    }

//    public T clickOnFirstLink(T page){
//        T t = null;
//        try {
//            Class<T> tClass=t.getClass();
//            AbstractPage abstractPage = t.getClass().newInstance();
//            t = page.getClass().newInstance();
//
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return t;
//    }
}
