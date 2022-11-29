package order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;
import pom.OrderPage;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String subwayStation;
    private final String address;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address, String subwayStation, String phoneNumber, String date, String rentalPeriod, String color, String comment){

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Test data: {0}{1}{2}{3}{4}{5}{6}{7}{8}")
    public static Object[][] getOrderInfo() {
        return new Object[][]{
                {"Екатерина", "Пирогова", "Москва, ул.Тверская, д.13", "Орехово", "89613773498", "29.11.2022", "сутки", "black", "прошу позвонить за 10 мин до доставки"},
                {"Олег", "Новиков", "Санкт-Петербург, ул.Красноармейская, д.28", "Студенческая", "89278849381", "31.12.2022", "трое суток", "grey", "зарядка должна быть максимальная"}
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/katerina/WebDriver/bin/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/Users/katerina/WebDriver/bin/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void orderTestOrderButtonInTop() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.open();
        mainPage.clickCookieButton();
        mainPage.clickToOrderButtonInTop();
        orderPage.inputDataToTheFirstPage(name, surname, address, subwayStation, phoneNumber);
        orderPage.inputDataToTheSecondPage(date, rentalPeriod, color, comment);
        orderPage.clickToYesButton();
        orderPage.checkOrderIsAccepted();
    }

    @Test
    public void orderTestOrderButtonInBottom() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.open();
        mainPage.clickCookieButton();
        mainPage.clickToOrderButtonInBottom();
        orderPage.inputDataToTheFirstPage(name, surname, address, subwayStation, phoneNumber);
        orderPage.inputDataToTheSecondPage(date, rentalPeriod, color, comment);
        orderPage.clickToYesButton();
        orderPage.checkOrderIsAccepted();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}