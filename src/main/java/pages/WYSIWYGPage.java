package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGPage {
    private  WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentBtn = By.cssSelector("[title=\"indentation\"] > button:nth-child(2)");

    public WYSIWYGPage(WebDriver driver){
        this.driver = driver;
    }
    public void clearTextArea(){
        switchToEditorArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditorArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public String getTextFromEditor(){
        switchToEditorArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    public void decreaseIndent(){
        driver.findElement(decreaseIndentBtn).click();
    }
    private void switchToEditorArea(){
        driver.switchTo().frame(editorIframeId);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
