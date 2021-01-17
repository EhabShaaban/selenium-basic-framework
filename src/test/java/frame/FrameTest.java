package frame;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.WYSIWYGPage;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTests {
    @Test
    public void testWYSIWYG(){
        WYSIWYGPage wysiwygPage = homePage.clickWYSIWYG();
        wysiwygPage.clearTextArea();
        String expectedText = "Frames sind Super!";
        wysiwygPage.setTextArea(expectedText);
        wysiwygPage.decreaseIndent();
        String actutalText = wysiwygPage.getTextFromEditor();
        assertEquals(actutalText, expectedText,"Text in frame doesn't match");
    }
}
