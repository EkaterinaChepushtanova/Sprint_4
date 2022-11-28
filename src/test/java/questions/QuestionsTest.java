package questions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

public class QuestionsTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/katerina/WebDriver/bin/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/Users/katerina/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage.open();
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);

        //принять куки
        mainPage.clickCookieButton();
    }

    @Test
    public void questionsTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.checkPriceQuestion();
        mainPage.checkQuantityQuestion();
        mainPage.checkRentalTimeQuestion();
        mainPage.checkOrderDateQuestion();
        mainPage.checkOrderPeriodQuestion();
        mainPage.checkChargingQuestion();
        mainPage.checkCancelOrderQuestion();
        mainPage.checkMcadQuestion();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



