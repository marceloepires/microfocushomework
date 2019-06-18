package testing.tests;

import org.testng.annotations.Test;
import testing.config.BaseClass;
import testing.config.CaptureScreenShot;
import testing.pages.InitialPage;

import java.io.IOException;

public class InvalidUserTest extends BaseClass {

    String url = "https://www.ebay.co.uk/";
    InitialPage initialPage;
    CaptureScreenShot captureScreenShot;

    @Test
    public void testingPractice() throws InterruptedException, IOException {
        driver.get(url);
        initialPage = new InitialPage(driver,wait);
        captureScreenShot = new CaptureScreenShot();

        initialPage.goToSignInPage();

        /*practicePage.selectCar("benz");
        practicePage.goToLoginPage();

        loginPage.enterUserEmail("marceloepires@hotmail.com");
        loginPage.enterPassword("Autotest");*/
        //captureScreenShot.captureScreen("test" ,driver);
        Thread.sleep(3000);

    }
}
