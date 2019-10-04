package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class OrderSummaryPage extends BasePageObject {

    @FindBy(xpath = "//meta[@name='viewport']")
    private WebElementFacade orderSummaryWindow;

    @FindBy(xpath = "//nav[@class='header']")
    private WebElementFacade header;

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    private WebElementFacade amount;

    @FindBy(xpath = "//a[@class='button-main-content']")
    private WebElementFacade continueBtn;

    @FindBy(xpath = "//div[@class='pull-right']")
    private WebElementFacade orderId;

    @FindBy(xpath = "//span[contains(text(),'shipping details')]")
    private WebElementFacade shippingDetailsTab;

    @FindBy(xpath = "//div[@class='text-body']")
    private List<WebElementFacade> shippingDetailList;

    @FindBy(xpath = "//div[@class='promo-text']")
    private WebElementFacade creditCard;

    public void orderSummaryDisplayed()
    {
        switchToFrame();
        amount.isDisplayed();
        header.isDisplayed();
        orderId.isDisplayed();

    }

    public void clickOnShippingDetailTab()
    {
        shippingDetailsTab.isDisplayed();
        shippingDetailsTab.click();

    }

    public boolean verifyShippingDetails()
    {
        for(int i=0;i<shippingDetailList.size();i++) {
            if (shippingDetailList.get(i) == null)return false;
        }
        return true;
    }

    public void clickOnContinueButton()
    {
        if(verifyShippingDetails()) continueBtn.click();
    }

    public void clickOnCreditCardPayment()
    {
        creditCard.click();
    }


}
