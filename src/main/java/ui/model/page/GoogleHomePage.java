package ui.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.model.ResultPageName;
import ui.model.page.result.AbstractGoogleResultPage;

/**
 * Created by okunets on 20.03.2017.
 */
public class GoogleHomePage extends AbstractPage {
    private static String GOOGLE_HOME_PAGE="https://www.google.com/en";
    @FindBy(css ="#lst-ib" )
    private WebElement searchBox;
    @FindBy(css = "#_fZl")
    private WebElement searchButton;
    private String query;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleHomePage navigateToHomePage() {
        driver.navigate().to(GOOGLE_HOME_PAGE);
        return this;
    }

    public GoogleHomePage inputQuery(String query){
        this.query=query;
        searchBox.sendKeys(query);
        return this;
    }

    public AbstractGoogleResultPage clickSearchButton(){
        searchButton.click();
        return firstResultPageFactory
                .getFirstGoogleResultPage(ResultPageName.valueOf(query.toUpperCase().replaceAll(" ","_")));
    }




}
