import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import page.HomePage;

public class MyTests {
    WebDriver driver;

    @BeforeGroups("testnet")
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = "testnet", priority = 1)
    @Description("Change language from english to ukrainian")
    public void ChangeLanguageToUkrainian(){
        HomePage homePage = new HomePage(driver)
                .openPage()
                .clickLanguageButton()
                .clickChangeLanguageToUkrainianButton();
        Assert.assertEquals(homePage.getLanguageButtonText(), "Українська");
    }
    @Test(groups = "testnet", priority = 2)
    public void ChangeThemeToLight() throws InterruptedException {
        HomePage homePage = new HomePage(driver)
                .openPage()
                .moveOnThemeSettings()
                .changeThemeOnLight();
        Assert.assertTrue(homePage.getThemeAttribute().contains("active"));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterGroups(groups = "testnet")
    public void close(){driver.close();}
}
