package testing.tests;

import org.testng.annotations.Test;
import testing.config.BaseClass;
import testing.config.CaptureScreenShot;
import testing.pages.LoginPage;
import testing.pages.PracticePage;

import java.io.IOException;

public class PracticeTest extends BaseClass {

    String url = "https://letskodeit.teachable.com/p/practice";
    PracticePage practicePage;
    LoginPage loginPage;
    CaptureScreenShot captureScreenShot;

    @Test
    public void testingPractice() throws InterruptedException, IOException {
        driver.get(url);
        practicePage = new PracticePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        captureScreenShot = new CaptureScreenShot();

        practicePage.selectCar("benz");
        practicePage.goToLoginPage();

        loginPage.enterUserEmail("marceloepires@hotmail.com");
        loginPage.enterPassword("Autotest");
        captureScreenShot.captureScreen("test" ,driver);
        Thread.sleep(3000);

    }
}
