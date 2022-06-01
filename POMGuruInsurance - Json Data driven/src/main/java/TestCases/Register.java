package TestCases;

import Pages.Insurance;
import Pages.Login;
import Pages.RegisterUserPage;
import Utility.JSONReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import Utility.JSONReader;


public class Register {
    WebDriver driver;
    RegisterUserPage objRegisterUserPage;
    Login objlogin;
    Insurance objInsurance;
    SoftAssert softAssert;
    WebDriverWait wait;
    Random random;

    @BeforeTest

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        random=new Random();
    }

    @Test
    public void registerUser() throws FileNotFoundException,IOException,ParseException {
        driver.get(JSONReader.ReadJSONFile("URL", "./Data/data.json"));


        objRegisterUserPage = new RegisterUserPage(driver);
        objlogin = new Login(driver);
        objInsurance=new Insurance(driver);


        //Click on Register button
        objRegisterUserPage.clickRegisterBtn();

        //Register User
        String email="test"+random.nextInt(50)+"@test.com";
        objRegisterUserPage.registerUser(JSONReader.ReadJSONFile("Title","./Data/data.json"), "David", "Doe", "12345", "1987", "May", "10", "5", "Engineer", "7th Lake Street", "Orlando", "USA", "100", email, "1234");

        softAssert.assertEquals(driver.getTitle(), "Insurance Broker System - Login");
//        softAssert.assertTrue(objlogin.getLoginTitle().contains("Insurance Broker System - Login"));


    // Login User

        objlogin.loginToInsurance(email,"1234");
        softAssert.assertTrue(objInsurance.validateUser().contains(email));

    }

    @AfterTest
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }
}
