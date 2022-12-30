package com.krafttech.step_Def;

import com.krafttech.pages.CartPage;
import com.krafttech.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {

    ProductPage productPage = new ProductPage();
    CartPage cartPage=new CartPage();

    @When("The user adds {string} to cart from {string}")
    public void the_user_adds_to_cart_from(String product, String category) {
        productPage.addProduct_mtd(product, category);
    }

    @When("The user removes {string} from cart")
    public void the_user_removes_from_cart(String product) {
        cartPage.removeProduct_mtd(product);
    }

    @When("The user places order and capture and log amount")
    public void the_user_places_order_and_capture_and_log_amount() {
        cartPage.finishPurchase_logAmount_mtd();

    }

    @Then("the user verifies purchase amount equals {int}")
    public void the_user_verifies_purchase_amount_equals(Integer expectedAmount) {
        cartPage.verifyPurchaseAmount_mtd(expectedAmount);
    }

}
