package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class HomePage extends Page {

    @Override
    public HomePage openPage() {
        driver.get("https://testnet.binancefuture.com/en/futures/BTCUSDT");
        return this;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLanguageButton(){
        WebElement languageButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("div[class='css-1ef19zs']")));
        languageButton.click();
        return this;
    }

    public HomePage clickChangeLanguageToUkrainianButton() {
        WebElement changeLanguageButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .id("fiatlngdialog_ba-languageRegion-ua")));
        changeLanguageButton.click();
        return this;
    }

    public String getLanguageButtonText(){
        WebElement languageText = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("div[class='css-1ef19zs']")));
        return languageText.getText();
    }

    public HomePage moveOnThemeSettings(){
        Actions actions = new Actions(driver);
        WebElement settings = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("svg[class='css-15bf2k5']")));
        actions.moveToElement(settings).build().perform();
        return this;
    }

    public HomePage changeThemeOnLight(){
        WebElement lightThemeButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("svg[class='css-16vuvx8']")));
        lightThemeButton.click();
        return this;
    }
    public String getThemeAttribute(){
        WebElement attribute = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("/html/body/div[13]/div/div[1]/div[2]/div[1]")));
        return attribute.getAttribute("class");
    }
}
