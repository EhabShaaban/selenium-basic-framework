package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testWait(){
        var loadingPage = homePage.clickDynamicLoading().clickDynamicLoadingExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedTexted(), "Hello World!", "Loaded text doesn't match");
    }
    @Test
    public void testWaitVisibilityOfElementLocated(){
        var loadingPage = homePage.clickDynamicLoading().clickDynamicLoadingExample2();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text doesn't match");
    }
}
