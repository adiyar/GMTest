import org.testng.annotations.Test;

public class testMaps extends initDriver {

    @Test
    public void searchAndZoom() {
        maps.searchPlace("Rome");
        for (int i = 1; i < 4; i++) {
            maps.takeFullScreenshot("Rome" + i);
            maps.zoomIn();
            sleepFor(1500);
        }
    }

}
