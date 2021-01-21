package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    /*
    * EventFiringWebDriver for executing functions before specific behavior
    * */
//    private EventFiringWebDriver driver;
    protected HomePage homePage;
    String url = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        /*driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());*/
        driver = new ChromeDriver(getChromeOptions());
        //driver.manage().window().setSize(new Dimension(375, 812));
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        goHome();
        setCookie();
    }
    @BeforeMethod
    public void goHome(){
        driver.get(url);
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/"+result.getName()+".png"));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    /*
    * helper methods
    * */
    public WindowManger getWindowManger(){
        return new WindowManger(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars");
//        options.setHeadless(true);
        return options;
    }
    private void setCookie(){
        Cookie cookie = new Cookie.Builder("cookieMachine", "123")
                .domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }
}
