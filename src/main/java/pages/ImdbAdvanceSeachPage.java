package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import javax.management.modelmbean.XMLParseException;

public class ImdbAdvanceSeachPage extends BasePageObject {

    @FindBy(xpath = "//a[contains(text(),'Advanced Title Search')]")
    private WebElementFacade advanceTitleSearch;

    @FindBy(xpath = "//label[contains(text(),'Top 250')]")
    private WebElementFacade checkBoxToSelectTop250;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElementFacade searchBtn;

    public void clickOnAdvanceTitleSearch()
    {
        advanceTitleSearch.waitUntilEnabled().expect("Element should be enabled").isEnabled();
        advanceTitleSearch.click();
    }

    //Not applying checks on these element as page load has been verified in previous step

    public void clickOnCheckBoxToSelectTop250()
    {
        checkBoxToSelectTop250.click();
    }

    public void clickOnSearchBtn()
    {
        searchBtn.click();
    }

}
