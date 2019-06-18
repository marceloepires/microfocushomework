package testing.tests;

import org.testng.annotations.Test;
import testing.config.BaseClass;
import testing.config.CaptureScreenShot;
import testing.pages.InitialPage;
import testing.pages.LoginPage;

import java.io.IOException;

public class InvalidUserTest extends BaseClass {

    String url = "https://www.ebay.co.uk/";
    InitialPage initialPage;
    LoginPage loginPage;
    CaptureScreenShot captureScreenShot;

    @Test
    public void testingPractice() throws InterruptedException, IOException {
        driver.get(url);
        initialPage = new InitialPage(driver,wait);
        loginPage = new LoginPage(driver,wait);
        captureScreenShot = new CaptureScreenShot();

        initialPage.goToSignInPage();
        loginPage.enterUserId("mmm@mm.com");
        loginPage.enterPass("abcd12");
        loginPage.clickSignInButton();
        loginPage.validateErrorMessage("Oops, that doesn't match.");

        Thread.sleep(3000);

    }
}
