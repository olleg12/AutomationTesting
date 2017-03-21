package ui_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by okunets on 20.03.2017.
 */
public class GoogleHomePage extends AbstractPage {



    @FindBy(css ="#lst-ib" )
    private WebElement searchBox;

    @FindBy(css = "#_fZl")
    private WebElement searchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public GoogleResultPage inputQuery(String query){
        searchBox.sendKeys(query);
        return new GoogleResultPage(driver);
    }

    public GoogleResultPage clickSearchButton(){
        searchButton.click();
        return new GoogleResultPage(driver);
    }


}
