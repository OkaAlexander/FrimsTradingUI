package testCase;

import com.beust.jcommander.Parameter;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends LandingPageTest {

    @ParameterizedTest
    @MethodSource("getLogInData")
    @DisplayName("Verify user login successfully with vslid credentials")

    void TC_001_LoginSuccess(String email, String password, String expectedResult) throws IOException,InterruptedException {
        //TC_001_LandingPage();
        loginPage.setEmail(email);
        logger.debug("emal entered");
        loginPage.setPassword(password);
        logger.debug("password entered");
        logger.debug("click");
        loginPage.clickLogin();
        String actualResult=null;

        try {
            if (loginPage.isLogOutBtnVisible())
                logger.atInfo();
                actualResult="successful";

        }catch (Exception e){
            actualResult="failure";
            assertTrue(loginPage.isErrorMessageDisplay(),"Error message not display");
        }
        assertEquals(actualResult,expectedResult);
    }


    public static Object[][] getLogInData(){
        Object[][] data={{"successb431@gmail.com","toomuchmoney","successful"}};
        return  data;
    }

}
