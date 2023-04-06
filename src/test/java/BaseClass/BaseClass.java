package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.ReadConfig;
import testCase.LoginTest;


public class BaseClass {
    protected static ReadConfig readConfig=new ReadConfig();
    protected static Logger logger;

    protected static LandingPage landingPage;
    protected static LoginPage loginPage;
    static WebDriver driver;
    @BeforeEach
public  void initializeDriver(){
    String browser = readConfig.lunchBrowser();


    switch(browser) {

        case "chrome":
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("disable-popup-blocking");
            driver=new ChromeDriver(options);
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("--remote-allow-origins=*");
            driver=new FirefoxDriver();
            break;

        case "ie":
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions internetExplorerOptions=new InternetExplorerOptions();
            internetExplorerOptions.addCommandSwitches("--remote-allow-origins=*");
            driver=new InternetExplorerDriver();
            break;

        default:
            System.out.println("Invalid browser specified");
            break;
    }
    driver.get(readConfig.getBaseUrl());
    driver.manage().window().maximize();
    landingPage =new LandingPage(driver);
    loginPage=new LoginPage(driver);
    logger= LogManager.getLogger(LoginTest .class.getName());


}
@AfterEach
public  void tearDown(){
        if(driver!=null){
            driver.quit();
        }
}
}
