package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }
    public void enterUpperLetter(){
        enterText(Keys.chord(Keys.LEFT_SHIFT, "p"));
    }
    public String getResult(){
        return driver.findElement(resultText).getText();
    }
}
