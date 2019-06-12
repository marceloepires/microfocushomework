package testing.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser){
        System.out.println("browser choice is: " + browser);
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./browsersDrivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("disable-infobars");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./browsersDrivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Wrong browser choice please check the possible options on BaseClass");
        }
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
