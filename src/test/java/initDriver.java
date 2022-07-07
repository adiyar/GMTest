import configuration.common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.factories.mapsMainPageAFactory;

public class initDriver extends common {
    public String URL = "https://www.google.com/maps/";

    @BeforeMethod
    public void driverStart() {
        driver = getWebDriver();
        maps = new mapsMainPageAFactory().getPageObject(driver);

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) driver.quit();
    }

    private WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;

    }

}
