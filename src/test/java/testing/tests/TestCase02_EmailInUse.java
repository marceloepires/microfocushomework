package testing.tests;

import org.testng.annotations.Test;
import testing.config.BaseClass;
import testing.pages.CreateAnAccountPage;
import testing.pages.InitialPage;
import testing.pages.LoginPage;

import java.io.IOException;

public class TestCase02_EmailInUse extends BaseClass {

    String url = "https://www.ebay.co.uk/";
    InitialPage initialPage;
    LoginPage loginPage;
    CreateAnAccountPage createAnAccountPage;

    @Test
    public void emailInUse() throws InterruptedException, IOException {
        driver.get(url);
        initialPage = new InitialPage(driver,wait);
        loginPage = new LoginPage(driver,wait);
        createAnAccountPage = new CreateAnAccountPage(driver,wait);

        initialPage.goToSignInPage();
        loginPage.clickCreateAccount();
        createAnAccountPage.enterFirstName(prop.getProperty("TC02.firstName"));
        createAnAccountPage.enterSurname(prop.getProperty("TC02.lastName"));
        createAnAccountPage.enterEmail(prop.getProperty("TC02.email"));
        createAnAccountPage.enterPassword(prop.getProperty("TC02.password"));
        createAnAccountPage.selectShowPass();
    }
}
