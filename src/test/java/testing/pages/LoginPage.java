package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="userid")
    private WebElement userId;

    @FindBy(id="InLineCreateAnAccount")
    private WebElement createAccount;

    @FindBy(id="pass")
    private WebElement pass;

    @FindBy(id="sgnBt")
    private WebElement signInButton;

    @FindBy(id="errf")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void enterUserId(String email){
        userId.sendKeys(email);
    }

    public void enterPass(String password){
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.sendKeys(password);
    }

    public void clickSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void clickCreateAccount(){
        wait.until(ExpectedConditions.visibilityOf(createAccount));
        createAccount.click();
    }

    public void validateErrorMessage(String error){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        String errorCaptured = errorMessage.getText();
        try {
            Assert.assertEquals(error,errorCaptured);
        } catch(Throwable t) {
            org.testng.Assert.fail("The error message is different than expected!");
        }

    }
}
