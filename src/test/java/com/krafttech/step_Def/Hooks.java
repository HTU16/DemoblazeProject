package com.krafttech.step_Def;


import com.krafttech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        Driver.closeDriver();
    }

}


//    @Before    //cucumber.java olacak.
//    public void setUp(){
//        System.out.println("\tThis is coming from Before Method");
//
////        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        Driver.get().manage().window().maximize();
//    }
//
//                                             // her bir senaryonun öncesinde ve sonrasında calışır..
//                                             // test başarısız olsa bile before after çalışır.
//    @After
//    public void tearDown(Scenario scenario){
//        System.out.println("\tThis is coming from After Method");
//
//        if(scenario.isFailed()){           // hatalı olan senaryoları screenshot olarak bize verir.
//            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png","screenshot");
//        }
//
//        Driver.closeDriver();
//    }
//
//    @Before("@GOT")
//    public void setUpDb(){
//        System.out.println("\t Connecting GOT");
//    }
//                                                 // parantez içinde seçtiğimiz tagların başında ve sonunda çalışır.
//    @After("@GOT")
//    public void tearDownDb(){
//        System.out.println("\t Disconnecting GOT");
//    }





