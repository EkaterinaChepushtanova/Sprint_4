package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class OrderPage {
    // поле для ввода имени
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // поле для ввода фамилии
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле для ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле для ввода метро
    private final By subwayStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    // поле для ввода номера телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка Далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // поле для выбора даты
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // поле для указания срока аренды
    private final By rentalTimeField = By.xpath(".//div[@class='Dropdown-placeholder']");

    // поле для комментария курьеру
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // кнопка заказать
    private final By toOrderButton = By.xpath(".//div[contains(@class,'Order_Buttons__1xGrp')]/button[text()='Заказать']");

    // кнопка Да
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");

    //окно заказ оформлен
    private final By orderIsAccepted = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String text) {
        driver.findElement(nameField).sendKeys(text);
    }

    public void inputSurname(String text) {
        driver.findElement(surnameField).sendKeys(text);
    }

    public void inputAddress(String text) {
        driver.findElement(addressField).sendKeys(text);
    }

    public void inputSubwayStation(String text) {
        driver.findElement(subwayStationField).click();
        driver.findElement(subwayStationField).sendKeys(text);
        driver.findElement(subwayStationField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void inputPhoneNumber(String text) {
        driver.findElement(phoneNumberField).sendKeys(text);
    }

    public void clickToNextButton() {
        driver.findElement(nextButton).click();
    }

    public void inputDate(String text) {
        driver.findElement(dateField).click();
        driver.findElement(dateField).sendKeys(text);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }

    public void inputRentalPeriod(String days) {
        driver.findElement(rentalTimeField).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='" + days + "']")).click();
    }

    public void chooseColor(String text) {
        driver.findElement(By.id(text)).click();
    }

    public void inputComment(String text) {
        driver.findElement(commentField).sendKeys(text);
    }

    public void clickToOrderButton() {
        driver.findElement(toOrderButton).click();
    }

    public void clickToYesButton() {
        driver.findElement(yesButton).click();
    }

    public void checkOrderIsAccepted() {
        String orderAccepted = driver.findElement(orderIsAccepted).getText();
        Assert.assertThat("Ошибка. Заказ не оформлен.", orderAccepted, startsWith("Заказ оформлен"));
    }

    public void inputDataToTheFirstPage(String name, String surname, String address, String subwayStation, String phoneNumber) {
        inputName(name);
        inputSurname(surname);
        inputAddress(address);
        inputSubwayStation(subwayStation);
        inputPhoneNumber(phoneNumber);
        clickToNextButton();
    }

    public void inputDataToTheSecondPage(String date, String rentalPeriod, String color, String comment) {
        inputDate(date);
        inputRentalPeriod(rentalPeriod);
        chooseColor(color);
        inputComment(comment);
        clickToOrderButton();
    }
}
