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

    @FindBy(xpath = "//a[@class='btn buy']")
    private WebElementFacade buyBtnOnHomePage;

    @FindBy(xpath = "//span[contains(text(),'Transaction failed')]")
    private WebElementFacade failureMsg;

    @FindBy(xpath = "//div[contains(text(),'success')]")
    private WebElementFacade successMsg;

    @FindBy(xpath = "//iframe[contains(@id,'snap')]")
    private WebElementFacade mainFrame;


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
        switchToFrame(mainFrame);
        successMsg.waitUntilVisible().expect("Buy button is not present on home page").isVisible();
        return successMsg.isDisplayed();
    }

    public boolean verifyFailureMessage()
    {
        switchToFrame(mainFrame);
        failureMsg.waitUntilVisible().expect("Failure message is not visible").isVisible();
        return failureMsg.isDisplayed();
    }
}
