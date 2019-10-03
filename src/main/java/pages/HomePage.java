package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;




public class HomePage extends BasePageObject {
    @FindBy(className = "ad-box")
    private WebElementFacade adBox;

    @FindBy(xpath = "//a[@class='btn buy']")
    private WebElementFacade buyNowBtn;

    public void clickOnBuyNow()
    {
        buyNowBtn.click();
    }
}
