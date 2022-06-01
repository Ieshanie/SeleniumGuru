package TestCases;

import Pages.Insurance;
import Pages.Login;
import Pages.RegisterUserPage;
import Utility.Common;
import Utility.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class Register {
    WebDriver driver;
    RegisterUserPage objRegisterUserPage;
    Login objlogin;
    Insurance objInsurance;
    SoftAssert softAssert;
    WebDriverWait wait;
    Random random;
    String email=Common.email();
//    static String email=null;

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


        objRegisterUserPage = new RegisterUserPage(driver);
        objlogin = new Login(driver);
        objInsurance = new Insurance(driver);


        //Navigate to the URL
        objRegisterUserPage.navigate(PropertyFileReader.readPropertyFile("URL", "./Data/data.properties"));

        //Click on Register button
        objRegisterUserPage.clickRegisterBtn();

        //Register User

        objRegisterUserPage.registerUser(
                PropertyFileReader.readPropertyFile("Title","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("FirstName","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Surname","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Phone","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Year","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Month","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Date","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("LicencePeriod","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Occupation","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Street","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("City","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("Country","./Data/data.properties"),
                PropertyFileReader.readPropertyFile("PostCode","./Data/data.properties"),
                email,
                PropertyFileReader.readPropertyFile("Password","./Data/data.properties"));


        softAssert.assertEquals(driver.getTitle(), "Insurance Broker System - Login");
        softAssert.assertTrue(objlogin.getLoginTitle().contains("Insurance Broker System - Login"));


        // Login User

        objlogin.loginToInsurance(email, PropertyFileReader.readPropertyFile("Password","./Data/data.properties"));
        softAssert.assertTrue(objInsurance.validateUser().contains(email));

    }

    @AfterTest
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }
}
