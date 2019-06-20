package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="firstname")
    private WebElement firstName;

    @FindBy(id="lastname")
    private WebElement lastName;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="PASSWORD")
    private WebElement pass;

    @FindBy(className = "checkbox__control")
    private WebElement show;

    @FindBy(id = "ppaFormSbtBtn")
    private WebElement registerButton;

    public CreateAnAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String name){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(name);
    }

    public void enterSurname(String surname){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys(surname);
    }

    public void enterEmail (String emailText){
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(emailText);
    }

    public void enterPassword (String password){
        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.sendKeys(password);
    }

    public void selectShowPass (){
        wait.until(ExpectedConditions.visibilityOf(show));
        if ( !show.isSelected() )
        {
            show.click();
        }
    }

    public void clickRegisterButton (){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        if (registerButton.isEnabled()){
            registerButton.click();
        }
    }
}
