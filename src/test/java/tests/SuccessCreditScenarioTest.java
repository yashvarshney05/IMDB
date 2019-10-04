package tests;

import common.BaseTestCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import pages.OrderSummaryPage;
import steps.CreditCardSteps;
import steps.OrderSummarySteps;
import steps.ShoppingCartSteps;
import steps.SuccessCreditScenarioSteps;
import utils.CommonUtils;

public class SuccessCreditScenarioTest extends BaseTestCase {

    @Steps
    SuccessCreditScenarioSteps successCreditScenarioStepsObj;

    @Steps
    ShoppingCartSteps shoppingCartStepsObj;

    @Steps
    OrderSummarySteps orderSummaryStepsObj;

    @Steps
    CreditCardSteps creditCardStepsObj;

    @Test
    public void verify_homepage() {
        String home_page_url = CommonUtils.getBaseUrl();
        successCreditScenarioStepsObj.open_home_page(home_page_url);
        successCreditScenarioStepsObj.user_on_click_buy_now();
        shoppingCartStepsObj.verify_Shopping_Cart_IsOpened();
        shoppingCartStepsObj.verify_user_details();
        shoppingCartStepsObj.click_on_checkout_button();
        orderSummaryStepsObj.verify_order_summary();
        orderSummaryStepsObj.click_on_shipping_details();
        orderSummaryStepsObj.verify_shipping_details();
        orderSummaryStepsObj.click_on_continue_button();
        orderSummaryStepsObj.click_on_credit_card();
        creditCardStepsObj.verify_credit_card_screen_is_displayed();
    }
}
