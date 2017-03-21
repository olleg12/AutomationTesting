package test_suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by okunets on 20.03.2017.
 */
public class GoogleHomePage extends AbstractPage {

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css ="#lst-ib" )
    private WebElement searchBox;

    String  a="gffg";
    @FindBy(css = ".jsb > center:nth-child(1) > input:nth-child(1)")
    private WebElement searchButton;


    public GoogleHomePage inputQuery(String query){
        searchBox.sendKeys(query);
        return this;
    }

    public GoogleHomePage clickSearchButtorn(){
        
    }
}
