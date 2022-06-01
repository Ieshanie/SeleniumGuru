package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Insurance {
    WebDriver driver;
    By logginUser= By.xpath("//*[contains(text(),'Signed in as')]/h4");

    public Insurance(WebDriver driver)
    {
        this.driver=driver;
    }


    public String validateUser(){
     return   driver.findElement(logginUser).getText();
    }
}
