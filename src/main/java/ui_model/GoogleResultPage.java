package ui_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleResultPage extends AbstractPage {
    private WebElement googleTranslateLink;
    @FindBy(css = ".sp_cnt > a:nth-child(2) > b:nth-child(1) > i:nth-child(1)")
    WebElement resultLink;
    @FindBy(css = ".sp_cnt > span:nth-child(1)")
    WebElement showResultsForSpan;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getValueOfShowingResultsFor() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sp_cnt > a:nth-child(2) > b:nth-child(1) > i:nth-child(1)")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sp_cnt > span:nth-child(1)")));
        return showResultsForSpan.getText()+" " +resultLink.getText();
    }


    public GoogleTranslatePage clickOnGoogleTranslateLink(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rso > div:nth-child(1) > div > div > div > h3 > a")));
        googleTranslateLink=driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > h3 > a"));
        googleTranslateLink.click();
        GoogleTranslatePage translatePage=new GoogleTranslatePage(driver);
        translatePage.setProperties(properties);
        return translatePage;
    }


}
