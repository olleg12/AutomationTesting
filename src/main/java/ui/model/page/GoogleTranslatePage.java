package ui.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by okunets on 21.03.2017.
 */
public class GoogleTranslatePage extends AbstractPage {
    private WebElement languageDiv;

    public GoogleTranslatePage(WebDriver driver) {
        super(driver);
    }

    public GoogleTranslatePage inputApple() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("source")));
        WebElement inputField = driver.findElement(By.id("source"));
        inputField.sendKeys("Apple");
        return this;
    }

    public String getTranslation() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result_box']/span")));
        WebElement outputField = driver.findElement(By.xpath("//*[@id=\"result_box\"]/span"));
        return outputField.getText();
    }



    public GoogleTranslatePage chooseLanguageToTranslateIn() throws InterruptedException {
        if (languageDiv == null)
            languageDiv = driver.findElement(By.xpath(".//*[@id='gt-tl-sugg']/div[2]"));
        languageDiv.click();
        return this;
    }


}
