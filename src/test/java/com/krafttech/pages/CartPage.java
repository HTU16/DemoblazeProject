package com.krafttech.pages;


import com.github.javafaker.Faker;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    int actualAmount;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderBtn_loc;
    @FindBy(id = "name")
    public WebElement name_loc;
    @FindBy(id = "country")
    public WebElement country_loc;
    @FindBy(id = "city")
    public WebElement city_loc;
    @FindBy(id = "card")
    public WebElement creditCard_loc;
    @FindBy(id = "month")
    public WebElement month_loc;
    @FindBy(id = "year")
    public WebElement year_loc;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseBtn_loc;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmationMessage_loc;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement ok_loc;


    public void removeProduct_mtd(String product){
        BrowserUtils.waitForClickablility(cart_loc,3).click();
        WebElement deleteProduct = Driver.get().findElement(By.xpath("//td[.='"+product+"']/..//a[text()='Delete']"));
        BrowserUtils.waitForClickablility(deleteProduct,3);
        deleteProduct.click();
        BrowserUtils.waitFor(2);
    }
    public void fillForm_mtd(){
        Faker faker=new Faker();
        BrowserUtils.waitFor(1);
        name_loc.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        country_loc.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        city_loc.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        creditCard_loc.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month_loc.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        BrowserUtils.waitFor(1);
        year_loc.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        BrowserUtils.waitFor(1);
    }

    public void finishPurchase_logAmount_mtd(){
        BrowserUtils.waitForClickablility(placeOrderBtn_loc,4).click();
        fillForm_mtd();
        BrowserUtils.waitForClickablility(purchaseBtn_loc,4).click();

        String confirmationMessage = confirmationMessage_loc.getText();
        System.out.println("confirmationMessage = " + confirmationMessage);

        String [] confirmationArray=confirmationMessage.split("\n");

        actualAmount= Integer.parseInt(confirmationArray[1].split(" ")[1]);
        BrowserUtils.waitFor(2);
        ok_loc.click();

    }
    public void verifyPurchaseAmount_mtd(int expectedAmount){
        Assert.assertEquals(expectedAmount,actualAmount);
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("actualAmount = " + actualAmount);
    }


}