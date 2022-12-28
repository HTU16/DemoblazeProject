package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {       //  //testNG de testBase karşılığı..


    // Bu page diger pageler icin ortak oldugundan buradan
    // diger pagelerde oldugu gibi obje olusturup kullanilmamasi gerekiyor.
    // Bunun icin de abstract yapiyoruz buraya diğer page leri extends edicez.
    // Ancak diger pages extends yaparak bu classa ait metodlari locatorlari kullanabilir


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "login2")
    public WebElement login_homePage_loc;

}
