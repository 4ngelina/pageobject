package page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    protected abstract Page openPage();
    protected final int WAIT_TIMEOUT_SECONDS=10;

    protected Page(WebDriver driver){
        this.driver = driver;
    }
}
