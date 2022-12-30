package com.krafttech.pages;


import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {


    @FindBy(id = "loginusername")
    public WebElement loginusername_loc;
    @FindBy(id = "loginpassword")
    public WebElement loginpassword_loc;
    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginBtn_loc;

    public void login_mtd() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginusername_loc.sendKeys(username);
        loginpassword_loc.sendKeys(password);
        loginBtn_loc.click();
        BrowserUtils.waitFor(2);
    }

    public void login_mtd(String username,String password ){
        login_homePage_loc.click();
        loginusername_loc.sendKeys(username);
        loginpassword_loc.sendKeys(password);
        loginBtn_loc.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyNegatifLoginMessage(String expectedMessage){
        Alert alert= Driver.get().switchTo().alert();
        //BrowserUtils.waitFor(2);
        String actualMessage = alert.getText();       //alert switcTo metotları pop-up mesajları bulmada kullanılır.

        Assert.assertEquals("negative login Message does NOT Match",expectedMessage,actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);


    }

}


