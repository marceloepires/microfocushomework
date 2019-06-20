package testing.tests;

import org.testng.annotations.Test;
import testing.config.BaseClass;
import testing.pages.InitialPage;
import testing.pages.LoginPage;

import java.io.IOException;


public class TestCase01_InvalidUserTest extends BaseClass {

    String url = "https://www.ebay.co.uk/";
    InitialPage initialPage;
    LoginPage loginPage;

    @Test
    public void invalidUserTest() throws InterruptedException, IOException {
        driver.get(url);
        initialPage = new InitialPage(driver,wait);
        loginPage = new LoginPage(driver,wait);

        initialPage.goToSignInPage();
        loginPage.enterUserId(prop.getProperty("TC01.invalidEmail"));
        loginPage.enterPass(prop.getProperty("TC01.invalidPass"));
        loginPage.clickSignInButton();
        loginPage.validateErrorMessage(prop.getProperty("TC01.errorMsg"));
    }
}
