package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends AbstractPage{
    public LandingPage(WebDriver driver) {
        super(driver);
    }

   // private final By slideShow=By.xpath("//body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='master-column-wrapper']/div[@class='center-1']/div[@class='page home-page']/div[@class='page-body']/div[@class='slider-wrapper theme-custom']/div[@id='nivo-slider']/a[1]");
    private final By btnLogin=By.cssSelector(".ico-login");



    public WebElement waitAndFindWebElement(By locator){
        return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
   public void clickLogin(){
        waitAndFindWebElement(btnLogin).click();
   }

}
