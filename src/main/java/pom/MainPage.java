package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    // адрес сайта
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //кнопка Заказать в правом верхнем углу страницы
    private final By orderButtonInTop = By.xpath(".//div[contains(@class,'Header_Nav')]/button[@class='Button_Button__ra12g']");

    //кнопка Заказать внизу страницы
    private final By orderButtonAtTheBottom = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // куки
    private final By cookieButton = By.id("rcc-confirm-button");

    //Вопрос "Сколько это стоит? И как оплатить?"
    private final By priceQuestion = By.id("accordion__heading-0");
    //Вопрос "Хочу сразу несколько самокатов! Так можно?"
    private final By quantityQuestion = By.id("accordion__heading-1");
    //Вопрос "Как рассчитывается время аренды?"
    private final By rentalTimeQuestion = By.id("accordion__heading-2");
    //Вопрос "Можно ли заказать самокат прямо на сегодня?"
    private final By orderDateQuestion = By.id("accordion__heading-3");
    //Вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By orderPeriodQuestion = By.id("accordion__heading-4");
    //Вопрос "Вы привозите зарядку вместе с самокатом?"
    private final By chargingQuestion = By.id("accordion__heading-5");
    //Вопрос "Можно ли отменить заказ?"
    private final By cancelOrderQuestion = By.id("accordion__heading-6");
    //Вопрос "Я жизу за МКАДом, привезёте?"
    private final By mcadQuestion = By.id("accordion__heading-7");


    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get(url);
    }
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }
    public void clickToOrderButtonInTop(){
        driver.findElement(orderButtonInTop).click();
    }

    public void clickToOrderButtonInBottom() {
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonAtTheBottom).click();
    }

    public void checkPriceQuestion() {
        driver.findElement(priceQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", result);
        System.out.println("Ответ о цене соответствует требованиям.");
    }

    public void checkQuantityQuestion(){
        driver.findElement(quantityQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-1")).getText();
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkRentalTimeQuestion(){
        driver.findElement(rentalTimeQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-2")).getText();
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkOrderDateQuestion(){
        driver.findElement(orderDateQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-3")).getText();
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkOrderPeriodQuestion(){
        driver.findElement(orderPeriodQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-4")).getText();
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkChargingQuestion(){
        driver.findElement(chargingQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-5")).getText();
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkCancelOrderQuestion(){
        driver.findElement(cancelOrderQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-6")).getText();
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkMcadQuestion(){
        driver.findElement(mcadQuestion).click();
        String result = driver.findElement(By.id("accordion__panel-7")).getText();
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", result);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }
}
