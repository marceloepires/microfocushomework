package testing.config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShot {
    private DateFormat dateFormater = new SimpleDateFormat("ddMMyyyyHHmmssSSS");

    public String captureScreen(String fileName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        Date currentDate = new Date();

        String pathScreenshot = "./target/screenshot/"+ fileName +"_" + dateFormater.format(currentDate) + ".png";

        FileUtils.copyFile(source, new File(pathScreenshot));
        return pathScreenshot;
    }
}
