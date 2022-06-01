package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    By email = By.id("email");
    By password=By.id("password");
    By loginBtn=By.name("submit");


    public Login(WebDriver driver) {
        this.driver = driver;
    }


    By loginTitle = By.xpath("//*[contains(text(),'Insurance Broker System - Login')]");


    public String getLoginTitle() {
        return driver.findElement(loginTitle).getText();
    }

    public void setEmail(String setEmail) {
        driver.findElement(email).sendKeys(setEmail);
    }

    public void setPassword(String setPassword){
        driver.findElement(password).sendKeys(setPassword);
    }

    public void clickEnter()
    {
        driver.findElement(loginBtn).click();
    }

    public void loginToInsurance(String enterEmail,String enterPassword) {
        setEmail(enterEmail);
        setPassword(enterPassword);
        clickEnter();
    }
}

