package scroll;

import base.BaseTests;
import org.testng.annotations.Test;

public class ScrollTests extends BaseTests {
    @Test
    public void testScrollToTable(){
        var scrollPage =  homePage.clickLargeDeepDOM();
        scrollPage.scrollToTable();
    }
    @Test
    public void testScrollToFourthTextBlock(){
        var infinitePage = homePage.clickInfiniteScroll();
        infinitePage.scrollToTextBlock(5);
    }
}
