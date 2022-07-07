package pageObjects.factories;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.mapsMainAPage;

public class mapsMainPageAFactory {
    public mapsMainAPage getPageObject(WebDriver driver) {
        return new mapsMainAPage(driver);
    }
}
