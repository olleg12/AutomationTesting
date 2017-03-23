package ui_model.page.result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_model.page.AbstractPage;
import ui_model.page.result.first.FirstGoogleResultPageApple;

import java.util.List;

/**
 * Created by okunets on 21.03.2017.
 */
public abstract class AbstractGoogleResultPage extends AbstractPage {
    @FindBy(css = ".r>a")
    private WebElement firstResultLink;
    @FindBy(css = ".sp_cnt > a:nth-child(2) > b:nth-child(1) > i:nth-child(1)")
    private WebElement resultLink;
    @FindBy(css = ".sp_cnt > span:nth-child(1)")
    private WebElement showResultsForSpan;
    @FindBy(css = ".rc>.r>a")
    protected List<WebElement> resultLinks;
    protected  int pageNumber;

    public AbstractGoogleResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract AbstractGoogleResultPage navigateToPageNumber(int number);
    public abstract int calculateResultsNumber();

    public String getValueOfShowingResultsFor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sp_cnt > a:nth-child(2) > b:nth-child(1) > i:nth-child(1)")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sp_cnt > span:nth-child(1)")));
        return showResultsForSpan.getText() + " " + resultLink.getText();
    }

    protected AbstractGoogleResultPage navigateToFirstLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".r>a")));
        firstResultLink.click();
        return this;
    }



}
