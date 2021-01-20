package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManger;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    String url = "https://the-internet.herokuapp.com/";
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(375, 812));
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        goHome();
    }
    @BeforeMethod
    public void goHome(){
        driver.get(url);
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManger getWindowManger(){
        return new WindowManger(driver);
    }
}
