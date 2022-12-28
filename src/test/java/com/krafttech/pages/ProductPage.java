package com.krafttech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername_loc;
    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCart_loc;

    public void verifyLogin_mtd(String expectedUsername) {
        String actualUsername = welcomeUsername_loc.getText();
        Assert.assertEquals("user does NOT match", expectedUsername, actualUsername);
        System.out.println("expectedUsername = " + expectedUsername);
        System.out.println("actualUsername = " + actualUsername);
    }

}
