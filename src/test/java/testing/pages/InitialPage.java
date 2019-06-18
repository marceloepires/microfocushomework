package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InitialPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText="Sign in")
    private WebElement signIn;

    @FindBy(css="input[name='user[password]']")
    private  WebElement userPassword;

    public InitialPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    public void goToSignInPage(){
        signIn.click();
    }


    public void enterPassword(String pass){
        userPassword.sendKeys(pass);
    }
}
