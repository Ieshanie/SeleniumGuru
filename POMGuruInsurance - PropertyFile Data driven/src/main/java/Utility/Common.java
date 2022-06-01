package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Common {

    public static String email() {
        Random random = new Random();
        String str = PropertyFileReader.readPropertyFile("Email", "./Data/data.properties");
        String split_first = str.substring(0, str.indexOf("@"));
        String split_second = str.substring(str.indexOf("@") + 1);
        String email = split_first + random.nextInt(50) + "@" + split_second;
        return email;
    }

    public  static void typeOnElement(String inputValue, By element,WebDriver driver) {
        driver.findElement(element).sendKeys(inputValue);

    }


}
