package Utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaifForElement {

    public static void waitForElement(WebDriver driver, By element){
        WebDriverWait wait=new WebDriverWait(driver,30 );
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
