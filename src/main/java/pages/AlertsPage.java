package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;

    //1st alert locater
    private By triggerAlertBtn = By.xpath("//button[text()=\"Click for JS Alert\"]");
    //2nd alert locater
    private By triggerConfirmBtn = By.xpath("//button[text()=\"Click for JS Confirm\"]");
    //3rd alert locator
    private By triggerPromtBtn = By.xpath("//button[text()=\"Click for JS Prompt\"]");
    //shared locator for all 3 alerts
    private By alertResultText = By.id("result");


    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }
    public String getAlertResult() {
        return driver.findElement(alertResultText).getText();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void sendInputToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //1st alert methods
    public void triggerAlertBtn(){
        driver.findElement(triggerAlertBtn).click();
    }
    //2nd alert methods
    public void triggerConfirmBtn(){
        driver.findElement(triggerConfirmBtn).click();
    }
    //3rd alert methods
    public void triggerPromtBtn(){
        driver.findElement(triggerPromtBtn).click();
    }
}
