package Pages;

import Utility.Common;
import Utility.WaitForElement;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserPage {
    WebDriver driver;
    WebDriverWait wait;
    Common common;


    By registerUserBtn = By.xpath("//*[contains(text(),'Register')]");
    By registerUserPage = By.xpath("//*[contains(text(),'Sign up as a new user')]");
    By title = By.id("user_title");
    By firstName = By.id("user_firstname");
    By surName = By.id("user_surname");
    By phone = By.id("user_phone");
    By year = By.id("user_dateofbirth_1i");
    By month = By.id("user_dateofbirth_2i");
    By date = By.id("user_dateofbirth_3i");
    By licenceType = By.id("licencetype_f");
    By licencePeriod = By.id("user_licenceperiod");
    By occupation = By.id("user_occupation_id");
    By street = By.id("user_address_attributes_street");
    By city = By.id("user_address_attributes_city");
    By country = By.id("user_address_attributes_county");
    By postCode = By.id("user_address_attributes_postcode");
    By email = By.id("user_user_detail_attributes_email");
    By password = By.id("user_user_detail_attributes_password");
    By confirmPassword = By.id("user_user_detail_attributes_password_confirmation");
    By sumbitBtn = By.name("submit");






    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterBtn() {
//        wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(registerUserBtn));
        WaitForElement.waitForElement(driver,registerUserBtn);
        driver.findElement(registerUserBtn).click();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerUserPage));


    }

    //SetTitle
    public void setTitle(String strTitle) {
        Select drpTitle = new Select(driver.findElement(title));
        drpTitle.selectByVisibleText(strTitle);
    }

    //    Set FirstName
    public void setFirstName(String strFirstName) {
//        driver.findElement(firstName).sendKeys(strFirstName);
        Common.typeOnElement(strFirstName,firstName,driver);
    }

    //    Set SurName
    public void setSurname(String strSurname) {
        driver.findElement(surName).sendKeys(strSurname);
    }

    //    Set Phone
    public void setPhone(String strPhone) {
        driver.findElement(phone).sendKeys(strPhone);
    }

    //    Set DateOfBirth
    public void setYear(String strYear) {
        Select drpYear = new Select(driver.findElement(year));
        drpYear.selectByVisibleText(strYear);
    }

    public void setMonth(String strMonth) {
        Select drpMonth = new Select(driver.findElement(month));
        drpMonth.selectByVisibleText(strMonth);
    }

    public void setDate(String strDate) {
        Select drpDate = new Select(driver.findElement(date));
        drpDate.selectByVisibleText(strDate);
    }

    //    Set LicenceType
    public void setLicenceType() {
        driver.findElement(licenceType).click();
    }

    //    Set LicencePeriod
    public void setLicencePeriod(String strLicencePeriod) {
        Select drpLicencePeriod = new Select(driver.findElement(licencePeriod));
        drpLicencePeriod.selectByVisibleText(strLicencePeriod);
    }

    //    Set Occupation
    public void setOccupation(String strOccupation) {
        Select drpOccupation = new Select(driver.findElement(occupation));
        drpOccupation.selectByVisibleText(strOccupation);
    }

    //Set Street
    public void setStreet(String strStreet) {
        driver.findElement(street).sendKeys(strStreet);
    }

    //Set City
    public void setCity(String strCity) {
        driver.findElement(city).sendKeys(strCity);
    }

    //Set Country
    public void setCountry(String strCountry) {
        driver.findElement(country).sendKeys(strCountry);

    }

    //Set PostCode
    public void setPostCode(String strPostCode) {
        driver.findElement(postCode).sendKeys(strPostCode);
    }

    //Set Email
    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    //Set Password
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
        driver.findElement(confirmPassword).sendKeys(strPassword);
    }

    //Click Submit
    public void clickSubmit() {
        driver.findElement(sumbitBtn).click();
    }

    public void navigate(String url){
        driver.get(url);
    }

    public void registerUser(String strTitle, String strFirstName, String strSurname, String strPhone, String strYear, String strMonth, String strDate, String strLicencePeriod, String strOccupation, String strStreets, String strCity, String strCountry, String strPostCode, String strEmail, String strPassword) {
        this.setTitle(strTitle);
        this.setFirstName(strFirstName);
        this.setSurname(strSurname);
        this.setPhone(strPhone);
        this.setYear(strYear);
        this.setMonth(strMonth);
        this.setDate(strDate);
        this.setLicenceType();
        this.setLicencePeriod(strLicencePeriod);
        this.setOccupation(strOccupation);
        this.setStreet(strStreets);
        this.setCity(strCity);
        this.setCountry(strCountry);
        this.setPostCode(strPostCode);
        this.setEmail(strEmail);
        this.setPassword(strPassword);
        this.clickSubmit();

    }
}
