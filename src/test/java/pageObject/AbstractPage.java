package pageObject;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import testCase.LoginTest;

import java.time.Duration;

public class AbstractPage {
    protected WebDriver driver;
    protected Wait wait;
    public AbstractPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
