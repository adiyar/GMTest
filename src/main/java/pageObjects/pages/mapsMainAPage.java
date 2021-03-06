package pageObjects.pages;

import configuration.common;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@Getter
public class mapsMainAPage extends common {

    @FindBy(xpath = "//input[@id='searchboxinput']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@id='searchbox-searchbutton']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@id='widget-zoom-in']")
    private WebElement zoomInButton;

    public mapsMainAPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class).withTimeout(Duration.ofSeconds(30));
    }

    public void searchPlace(String search) {
        fluentWait.until(ExpectedConditions.visibilityOf(getSearchInput())).sendKeys(search);
        fluentWait.until(ExpectedConditions.visibilityOf(getSearchButton())).click();
        fluentWait.until(ExpectedConditions.visibilityOf(getZoomInButton()));
    }

    public void zoomIn() {
        fluentWait.until(ExpectedConditions.visibilityOf(getZoomInButton())).click();
    }
}
