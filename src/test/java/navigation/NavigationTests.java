package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickDynamicLoadingExample1();
            getWindowManger().goBack();
        getWindowManger().refreshPage();
        getWindowManger().goForward();
        getWindowManger().goTo("https://www.google.com");
    }
    @Test
    public void clickMultipleWindows(){
        var mulWindPage = homePage.clickMultipleWindows();
        mulWindPage.clickHere();
        for(int i =0 ; i < 10 ; i++){
            getWindowManger().switchToTab("New Window");
            getWindowManger().switchToTab("The Internet");
        }
    }
}
