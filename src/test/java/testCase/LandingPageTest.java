package testCase;

import BaseClass.BaseClass;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LandingPageTest extends BaseClass {

    @Test
    @DisplayName("Verify my account button is clickable and drop register and login")
    void TC_001_LandingPage(){
        landingPage.clickLogin();


    }
}
