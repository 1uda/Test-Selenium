import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class firstpage {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver-win64/chromedriver.exe");
    }
    @BeforeEach
    void setUp() { driver = new ChromeDriver();}

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
    @Test
    void loginPageTestPositive() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("test@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();

    }
    @Test
    void loginPageTestNegativeEmail() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("123@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        String expexted = "Неверный E-Mail или пароль";
        String actual = driver.findElement(By.xpath("//div[text()='Неверный E-Mail или пароль']")).getText();
        assertEquals(expexted, actual);

    }

    @Test
    void loginPageTestNegativePass() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("test@protei.ru");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("tets");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        String expexted = "Неверный E-Mail или пароль";
        String actual = driver.findElement(By.xpath("//div[text()='Неверный E-Mail или пароль']")).getText();
        assertEquals(expexted, actual);
    }

    @Test
    void dataPageTestPositive() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("test@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        driver.findElement(By.xpath("//input[@id='dataEmail']")).sendKeys("123@mail.ru");
        driver.findElement(By.xpath("//input[@id='dataName']")).sendKeys("Саша");
        //driver.findElement(By.xpath("//option[text()='Мужской']")).click();
        driver.findElement(By.xpath("//option[text()='Женский']")).click();
        driver.findElement(By.xpath("//input[@id='dataCheck11']")).click();
        //driver.findElement(By.xpath("//input[@id='dataCheck12']")).click();
        driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect22']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();
        Thread.sleep(5000);
        String expexted = "Данные добавлены.";
        String actual = driver.findElement(By.xpath("//div[text()='Данные добавлены.']")).getText();
        assertEquals(expexted, actual);
    }

    @Test
    void dataPageIncorrectEmail() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("test@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        driver.findElement(By.xpath("//input[@id='dataEmail']")).sendKeys("123@");
        driver.findElement(By.xpath("//input[@id='dataName']")).sendKeys("Саша");
        driver.findElement(By.xpath("//option[text()='Мужской']")).click();
        //driver.findElement(By.xpath("//option[text()='Женский']")).click();
        driver.findElement(By.xpath("//input[@id='dataCheck11']")).click();
        //driver.findElement(By.xpath("//input[@id='dataCheck12']")).click();
        driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect22']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();
        Thread.sleep(1000);
        String expexted = "Неверный формат E-Mail";
        String actual = driver.findElement(By.xpath("//div[text()='Неверный формат E-Mail']")).getText();
        assertEquals(expexted, actual);
    }
    @Test
    void dataPageMarksEmailTest() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("te!st@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        driver.findElement(By.xpath("//input[@id='dataEmail']")).sendKeys("12%3@mail.ru");
        driver.findElement(By.xpath("//input[@id='dataName']")).sendKeys("Саша");
        driver.findElement(By.xpath("//option[text()='Мужской']")).click();
        //driver.findElement(By.xpath("//option[text()='Женский']")).click();
        driver.findElement(By.xpath("//input[@id='dataCheck11']")).click();
        //driver.findElement(By.xpath("//input[@id='dataCheck12']")).click();
        driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect22']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();
        Thread.sleep(1000);
        String expexted = "Неверный формат E-Mail";
        String actual = driver.findElement(By.xpath("//div[text()='Неверный формат E-Mail']")).getText();
        assertEquals(expexted, actual);
    }

    @Test
    void dataPageTestEmailWithoutdomain() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("te!st@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        driver.findElement(By.xpath("//input[@id='dataEmail']")).sendKeys("123@mail");
        driver.findElement(By.xpath("//input[@id='dataName']")).sendKeys("Саша");
        driver.findElement(By.xpath("//option[text()='Мужской']")).click();
        //driver.findElement(By.xpath("//option[text()='Женский']")).click();
        driver.findElement(By.xpath("//input[@id='dataCheck11']")).click();
        //driver.findElement(By.xpath("//input[@id='dataCheck12']")).click();
        driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect22']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();
        Thread.sleep(1000);
        String expexted = "Неверный формат E-Mail";
        String actual = driver.findElement(By.xpath("//div[text()='Неверный формат E-Mail']")).getText();
        assertEquals(expexted, actual);
    }

    @Test
    void dataPageTestIncorrectName() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("test@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        driver.findElement(By.xpath("//input[@id='dataEmail']")).sendKeys("123@mail.ru");
        driver.findElement(By.xpath("//input[@id='dataName']")).sendKeys("Са7ша");
        driver.findElement(By.xpath("//option[text()='Мужской']")).click();
        //driver.findElement(By.xpath("//option[text()='Женский']")).click();
        driver.findElement(By.xpath("//input[@id='dataCheck11']")).click();
        //driver.findElement(By.xpath("//input[@id='dataCheck12']")).click();
        driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect22']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();
        Thread.sleep(1000);
        String expexted = "Неверный формат Имя";
        String actual = driver.findElement(By.xpath("//div[text()='Неверный формат Имя']")).getText();
        assertEquals(expexted, actual);
    }

    @Test
    void dataPageTestEmptyName() throws InterruptedException {
        driver.get("file:///C:/Users/COM_B_PEKE/Desktop/Test/Selenium/qa-test.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginEmail']")).sendKeys("test@protei.ru");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='loginPassword']")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Вход']")).click();
        driver.findElement(By.xpath("//input[@id='dataEmail']")).sendKeys("123@mail.ru");
        driver.findElement(By.xpath("//input[@id='dataName']")).sendKeys("");
        driver.findElement(By.xpath("//option[text()='Мужской']")).click();
        //driver.findElement(By.xpath("//option[text()='Женский']")).click();
        driver.findElement(By.xpath("//input[@id='dataCheck11']")).click();
        //driver.findElement(By.xpath("//input[@id='dataCheck12']")).click();
        driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect22']")).click();
        //driver.findElement(By.xpath("//input[@id='dataSelect21']")).click();
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();
        Thread.sleep(1000);
        String expexted = "Поле имя не может быть пустым";
        String actual = driver.findElement(By.xpath("//div[text()='Поле имя не может быть пустым']")).getText();
        assertEquals(expexted, actual);
    }



    }

