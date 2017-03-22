package ui_model.page.result.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_model.page.result.AbstractGoogleResultPage;
import ui_model.page.result.other.OtherGoogleResultPageApple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by okunets on 22.03.2017.
 */
public class FirstGoogleResultPageApple extends FirstGoogleResultPage {
    @FindBy(css = "._Iqg")
    private WebElement newsLink;
    @FindBy(css = ".cMjHbjVt9AZ__button")
    private WebElement mapLink;
    public FirstGoogleResultPageApple(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractGoogleResultPage navigateToPageNumber(int number) {
//        if (number==pageNumber){
//            return this;
//        }
        WebElement pageNumberLink = driver.findElement(By.cssSelector("#nav > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(3) > a:nth-child(1)"));
        pageNumberLink.click();
        return new OtherGoogleResultPageApple(driver);
    }

    @Override
    public int calculateResultsNumber() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc>.r>a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._Iqg")));
        List<WebElement>webElements=new ArrayList<>();
        webElements.addAll(resultLinks);
        webElements.add(newsLink);
        webElements.add(mapLink);
        return webElements.size();
    }


    public AbstractGoogleResultPage clickOnFirstLink() {
        return null;
    }
}
