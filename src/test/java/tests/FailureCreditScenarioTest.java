package tests;

import common.BaseTestCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.CreditCardSteps;
import steps.OrderSummarySteps;
import steps.ShoppingCartSteps;
import steps.HomePageSteps;
import utils.CommonUtils;

public class FailureCreditScenarioTest extends BaseTestCase {

    static String cvv="123";
    static String otp="112233";

    @Steps
    HomePageSteps successCreditScenarioStepsObj;

    @Steps
    ShoppingCartSteps shoppingCartStepsObj;

    @Steps
    OrderSummarySteps orderSummaryStepsObj;

    @Steps
    CreditCardSteps creditCardStepsObj;

    @Test
    public void verify_failure_scenario() {
        String home_page_url = CommonUtils.getBaseUrl();
        String cardNumber="4911 1111 1111 1113";
        String expiryDate="02/20";
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
        creditCardStepsObj.user_enter_credit_card_number(cardNumber);
        creditCardStepsObj.user_enter_expiry_date(expiryDate);
        creditCardStepsObj.user_enter_cvv_number(cvv);
        creditCardStepsObj.click_on_pay_now();
        creditCardStepsObj.user_enter_otp(otp);
        creditCardStepsObj.user_click_on_ok_button();;
        creditCardStepsObj.verify_failure_message();
    }
}
