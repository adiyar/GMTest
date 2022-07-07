package configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import pageObjects.pages.mapsMainAPage;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import static java.lang.System.getProperty;

public class common {
    public WebDriver driver;
    public FluentWait<WebDriver> fluentWait;
    public mapsMainAPage maps;

    public void sleepFor(int sleep) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(sleep));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeFullScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            /// change directory to your computer
            String tempDir = getProperty("java.io.tmpdir");
            File destFile = new File(Paths.get(tempDir, fileName + ".png").toString());
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception e) {
            System.out.println("couldn't take screen shot");
        }
    }


}
