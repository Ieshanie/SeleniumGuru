package SelPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
import java.util.Random;

public class GuruInsurance {
    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;
    Random random;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        random = new Random();


    }

    @Test
    public void registerUser() {
//        Get URL
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
//        driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Sign up as a new user')]")));

//        Select Title
        Select title = new Select(driver.findElement(By.id("user_title")));
        title.selectByVisibleText("Mrs");

//        Enter FirstName
        driver.findElement(By.id("user_firstname")).sendKeys("David");

//        Enter Surname
        driver.findElement(By.id("user_surname")).sendKeys("Doe");

//        Enter Phone
        driver.findElement(By.id("user_phone")).sendKeys("12345");

//        Select Date of Birth
        Select year = new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        year.selectByVisibleText("1987");
        Select month = new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        month.selectByVisibleText("May");
        Select date = new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        date.selectByVisibleText("10");

//       Select Licence type
        driver.findElement(By.id("licencetype_f")).click();

//        Select Licence Period
        Select licencePeriod = new Select(driver.findElement(By.id("user_licenceperiod")));
        licencePeriod.selectByVisibleText("5");

//        Occupation
        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText("Engineer");

//        Address
        driver.findElement(By.id("user_address_attributes_street")).sendKeys("Main street");
        driver.findElement(By.id("user_address_attributes_city")).sendKeys("Orlando");
        driver.findElement(By.id("user_address_attributes_county")).sendKeys("USA");
        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("AA1");

//        Email
        String email = "david" + random.nextInt(50) + "@test.com";
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys(email);

//        Password
        String password = "123";
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(password);
        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(password);

//        Submit
        driver.findElement(By.name("submit")).click();
        softAssert.assertEquals(driver.getTitle(), "Insurance Broker System - Login");


//        Login
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Broker Insurance WebPage')]")));


//        Signed user Validation
        String loginEmail = driver.findElement(By.xpath("//*[contains(text(),'Signed in as')]/h4")).getText();
        softAssert.assertEquals(loginEmail, email);

    }


    @AfterTest
    public void tearDown() {
        softAssert.assertAll();
        driver.close();
        driver.quit();
    }
}
