package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends LandingPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By email=By.cssSelector("input[class='email']");
    private final By password=By.cssSelector("#Password");
    private final By btnLogin=By.cssSelector("button[class='button-1 login-button']");
    private final By btnLogOut=By.cssSelector(".ico-logout");
    private final By errorMessage=By.cssSelector("div.message-error.validation-summary-errors");


    private void inputField(By inputField,String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
        driver.findElement(inputField).clear();
        driver.findElement(inputField).sendKeys(text);
    }
    public void setEmail(String _email){
        inputField(email,_email);
    }
    public void setPassword(String _password){
        inputField(password,_password);
    }
    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }
    public String getAfterLoginPageTitle(){
      return   driver.getTitle();
    }

    public boolean isLogOutBtnVisible(){
        return waitAndFindWebElement(btnLogOut).isDisplayed();

    }
    public void clickLogout(){waitAndFindWebElement(btnLogOut).click();
    }
    public boolean isErrorMessageDisplay(){
        return waitAndFindWebElement(errorMessage).isDisplayed();
    }
}