package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css="#user_email")
    private WebElement userEmail;

    @FindBy(css="input[name='user[password]']")
    private  WebElement userPassword;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void enterUserEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        userEmail.sendKeys(email);
    }

    public void enterPassword(String pass){
        userPassword.sendKeys(pass);
    }


}
