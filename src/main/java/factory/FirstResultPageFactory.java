package factory;

import org.openqa.selenium.WebDriver;
import ui.model.page.result.first.FirstGoogleResultPage;
import ui.model.ResultPageName;
import ui.model.page.result.first.FirstGoogleResultPageApple;
import ui.model.page.result.first.FirstGoogleResultPageTranslate;

/**
 * Created by okunets on 22.03.2017.
 */
public class FirstResultPageFactory {
    private WebDriver webDriver;

    public FirstResultPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public FirstGoogleResultPage getFirstGoogleResultPage(ResultPageName name) {
        switch (name) {
            case APPLE:
                return new FirstGoogleResultPageApple(webDriver);
            case TRANSLATE_GOOGLE_COM:
                return new FirstGoogleResultPageTranslate(webDriver);
            default:
                throw new IllegalArgumentException("Current page object not implemented yet!");
        }

    }
}
