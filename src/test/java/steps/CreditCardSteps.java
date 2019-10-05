package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CreditCardPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CreditCardSteps extends ScenarioSteps {
    private CreditCardPage creditCardPageObj;

    @Step("Verify User is present on credit card page")
    public void verify_credit_card_screen_is_displayed()
    {
       assertThat(creditCardPageObj.verifyCreditCardPage()).overridingErrorMessage("Problem exists with credit card page").isTrue();
    }

    @Step("User enter credit card number")
    public void user_enter_credit_card_number(String creditCardNumber)
    {
        creditCardPageObj.enterCardNumber(creditCardNumber);
    }

    @Step("User enter expiry date")
    public void user_enter_expiry_date(String expiry)
    {
        creditCardPageObj.enterExpiryDate(expiry);
    }

    @Step("User enter cvv number")
    public void user_enter_cvv_number(String cvv)
    {
        creditCardPageObj.enterCvvNumber(cvv);
    }

    @Step("User click on pay now")
    public void click_on_pay_now()
    {
        creditCardPageObj.clickOnPayNow();
    }

    @Step("User enter OTP")
    public void user_enter_otp(String otp)
    {
        creditCardPageObj.enterOtp(otp);
    }

    @Step("User Click on OK button")
    public void user_click_on_ok_button()
    {
        creditCardPageObj.clickOnOkBtn();
    }

    @Step("Verify success message is present")
    public void verify_success_message()
    {
        assertThat(creditCardPageObj.verifySuccessMsg()).overridingErrorMessage("Success message not present").isTrue();
    }

    @Step("Verify failure message is present")
    public void verify_failure_message()
    {
        assertThat(creditCardPageObj.verifyFailureMessage()).overridingErrorMessage("Failure message not present").isTrue();
    }

}
