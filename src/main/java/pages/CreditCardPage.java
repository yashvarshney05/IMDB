package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreditCardPage extends BasePageObject {

    @FindBy(xpath = "//p[contains(text(),'Credit Card')]")
    private WebElementFacade creditCardPage;

    @FindBy(xpath = "//input[@name='cardnumber']")
    private WebElementFacade creditCardNumber;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    private WebElementFacade expiryDate;

    @FindBy(xpath = "//input[@placeholder='123']")
    private WebElementFacade cvvNumber;

    @FindBy(xpath = "//span[contains(text(),'Pay')]")
    private WebElementFacade payNowBtn;

    @FindBy(css = "input[type='password']")
    private WebElementFacade password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade ok;

    @FindBy(xpath = "//div[contains(text(),'Transaction']")
    private WebElementFacade successMsg;

    public boolean verifyCreditCardPage()
    {
        creditCardPage.waitUntilVisible().expect("Credit card page is not displayed").isVisible();
        creditCardNumber.waitUntilVisible().expect("Credit card number is not displayed").isEnabled();
        expiryDate.waitUntilVisible().expect("Expiry date is not displayed").isEnabled();
        cvvNumber.waitUntilVisible().expect("cvv number is not displayed").isEnabled();
        return creditCardPage.isDisplayed();
    }

    public void enterCardNumber(String cardNumber)
    {
        creditCardNumber.sendKeys(cardNumber);
    }

    public void enterExpiryDate(String date)
    {
        expiryDate.sendKeys(date);
    }

    public void enterCvvNumber(String cvv)
    {
        cvvNumber.sendKeys(cvv);
    }

    public void clickOnPayNow()
    {
        payNowBtn.click();
    }

    public void enterOtp(String otp)
    {
        switchToFrame();
        password.waitUntilVisible().expect("password box is not visible").isVisible();
        password.sendKeys(otp);
    }

    public void clickOnOkBtn()
    {
        ok.click();
    }

    public boolean verifySuccessMsg()
    {
        successMsg.waitUntilVisible().expect("Success message is not visible").isVisible();
        return successMsg.isDisplayed();
    }
}
