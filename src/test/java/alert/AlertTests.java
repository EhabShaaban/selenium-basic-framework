package alert;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlertMsg(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlertBtn();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getAlertResult(), "You successfuly clicked an alert", "Incorrect alert result text");
    }
    @Test
    public void testDismissConfirmAlertMsg(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirmBtn();
        String alertText = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        assertEquals(alertsPage.getAlertResult(), "You clicked: Cancel", "Incorrect alert result text");
        assertEquals(alertText, "I am a JS Confirm", "Incorrect alert message");
    }
    @Test
    public void testSendingInputToPrombtAlert(){
        String text = "Hey Text!";
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPromtBtn();
        alertsPage.sendInputToAlert(text);
        String alertText = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getAlertResult(), "You entered: "+text);
        assertEquals(alertText, "I am a JS prompt", "Incorrect alert message");

    }
}
