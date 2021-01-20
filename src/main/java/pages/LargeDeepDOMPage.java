package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeDeepDOMPage {
    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeDeepDOMPage(WebDriver driver){
        this.driver = driver;
    }
    public void scrollToTable(){
        //if ele is present in DOM
        WebElement tableElement = driver.findElement(table);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }
}
