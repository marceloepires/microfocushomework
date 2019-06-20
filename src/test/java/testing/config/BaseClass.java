package testing.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected InputStream in;
    protected Properties prop;

    @BeforeClass
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
        try {
            in = new FileInputStream("./src/test/java/testing/config/data.properties");
            prop = new Properties();
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterTest(){
        driver.quit();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
