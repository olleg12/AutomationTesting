package ui_model.page.result.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.result.first.FirstGoogleResultPageApple;

import java.util.List;


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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".rc>.r>a"),6));
        List<WebElement> elements = driver.findElements(By.cssSelector(".rc>.r>a"));
        return  elements.size();
    }
}
