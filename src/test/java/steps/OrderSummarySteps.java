package steps;

import core.BasePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.OrderSummaryPage;

public class OrderSummarySteps extends ScenarioSteps {

    OrderSummaryPage orderSummaryPageObj;
    BasePageObject basePageObject;

    @Step("Order summary window is dispalyed")
    public void verify_order_summary()
    {
        orderSummaryPageObj.orderSummaryDisplayed();
    }

    @Step("User Verify Shipping details")
    public void click_on_shipping_details()
    {
        orderSummaryPageObj.clickOnShippingDetailTab();
    }

     @Step("Verify all the shipping details")
     public void verify_shipping_details()
     {
         Assert.assertTrue("Shipping details are missing",orderSummaryPageObj.verifyShippingDetails());

     }

    @Step("User click on continue button")
    public void click_on_continue_button()
    {
       orderSummaryPageObj.clickOnContinueButton();
    }

    @Step("User select credit card for payment")
    public void click_on_credit_card()
    {
        orderSummaryPageObj.clickOnCreditCardPayment();
    }
}
