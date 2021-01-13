package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By uploadInputField = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(uploadInputField).sendKeys(absolutePathOfFile);
        clickUploadBtn();
    }
    public void clickUploadBtn(){
        driver.findElement(uploadBtn).click();
    }
    public String getUploadedFiles(){
        return driver.findElement(uploadedFiles).getText();
    }
}
