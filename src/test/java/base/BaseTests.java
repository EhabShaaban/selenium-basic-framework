package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    String url = "https://the-internet.herokuapp.com/";
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().setSize(new Dimension(375, 812));
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get(url);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
