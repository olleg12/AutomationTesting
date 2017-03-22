package ui_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleTranslatePage extends AbstractPage {

    private WebElement inputField;
    private WebElement outputField;
    private WebElement languagesDropdown;
    private WebElement romanianDiv;

    public GoogleTranslatePage(WebDriver driver) {
        super(driver);
    }

    public GoogleTranslatePage inputApple() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("source")));
        inputField = driver.findElement(By.id("source"));
        inputField.sendKeys(properties.getProperty("apple_query"));
        return this;
    }

    public String getTranslation() {
        if (outputField == null) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result_box']/span")));
            outputField = driver.findElement(By.xpath(properties.getProperty("translate_output_xpath")));
        }
        return outputField.getText();
    }

    public GoogleTranslatePage clickOnLanguagesDropdown() throws InterruptedException {
        if (languagesDropdown == null)
            languagesDropdown = driver.findElement(By.id(properties.getProperty("language_dropdown_id")));
        languagesDropdown.click();
        //Thread.sleep(5000);
        return this;
    }

    public GoogleTranslatePage chooseLanguageToTranslateIn() throws InterruptedException {
        if (romanianDiv == null)
            romanianDiv = driver.findElement(By.xpath(".//*[@id=':43']/div"));
//        Actions action = new Actions(driver);
//        action.moveToElement(romanianDiv).build().perform();
        System.out.println(romanianDiv.getText());
        Thread.sleep(1500);
        romanianDiv.click();


        return this;
    }


}
