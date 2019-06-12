package testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="carselect")
    private WebElement carSelect;

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    public PracticePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void selectCar(String value){
        Select sel = new Select(carSelect);
        sel.selectByValue(value);
    }

    public void goToLoginPage(){
        loginButton.click();
    }


}
