package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPage extends BasePageObject {

    @FindBy(xpath = "//div[@class='cart-content buying']")
    private WebElementFacade cartContainer;

    @FindBy(xpath = "//div[contains(text(),'CHECKOUT')]")
    private WebElementFacade checkoutBtn;

    @FindBy(xpath="//tr/td[2][contains(text(),'1')]")
    private WebElementFacade quantity;

    @FindBy(xpath = "//tr/td[3][contains(text(),'20')]")
    private WebElementFacade amount;

    @FindBy(xpath = "//input[@value='Budi']")
    private WebElementFacade custName;

    @FindBy(xpath = "//input[@value='budi@utomo.com']")
    private WebElementFacade email;

    @FindBy(xpath = "//input[@value='081808466410']")
    private WebElementFacade phoneNum;

    @FindBy(xpath = "//input[@value='Jakarta']")
    private WebElementFacade city;

    @FindBy(xpath = "//div[contains(text(),'Mid')]")
    private WebElementFacade address;

    @FindBy(xpath = "//input[@value='10220']")
    private WebElementFacade postalCode;

    @FindBy(xpath = "//iframe[contains(@id,'snap')]")
    private WebElementFacade mainFrame;


    public boolean isCartContainerDisplayed()
    {
        cartContainer.waitUntilVisible().expect("Shopping cart is visible").isVisible();
        return cartContainer.isDisplayed();
    }

    public void clickOnCheckoutButton()
    {
        if(checkoutBtn.isEnabled())
            checkoutBtn.click();
    }

    //It is assumed that all the necessary info should be mendatory before placing an order
    public boolean checkValidationBeforeOrderPlace()
    {
        if(amount.getValue()!=null && quantity.getValue()!=null && custName.getValue()!=null && email.getValue()!=null
        && city.getValue()!=null && address.getValue()!=null && postalCode.getValue()!=null)
            return true;
        return false;
    }
}
