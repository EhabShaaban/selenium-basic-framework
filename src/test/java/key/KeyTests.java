package key;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeyTests extends BaseTests {
    @Test
    public void testBackSpace() throws InterruptedException {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }
    @Test
    public void testUpperLetter(){
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterUpperLetter();
    }
}
