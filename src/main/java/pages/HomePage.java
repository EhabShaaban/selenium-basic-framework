package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    //private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickFormAuthentication(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public DropDownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }
    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        //wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Key Presses")));
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}