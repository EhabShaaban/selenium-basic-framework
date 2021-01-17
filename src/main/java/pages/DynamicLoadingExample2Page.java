package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By startBtn = By.cssSelector("#start button");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStart(){
        driver.findElement(startBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

}
