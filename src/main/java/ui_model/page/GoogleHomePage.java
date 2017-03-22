package ui_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_model.ResultPageName;
import ui_model.page.result.AbstractGoogleResultPage;

/**
 * Created by okunets on 20.03.2017.
 */
public class GoogleHomePage extends AbstractPage {
    @FindBy(css ="#lst-ib" )
    private WebElement searchBox;
    @FindBy(css = "#_fZl")
    private WebElement searchButton;
    private String query;
    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
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
