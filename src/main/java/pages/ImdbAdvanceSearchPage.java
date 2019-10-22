package pages;

import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;



public class ImdbAdvanceSearchPage extends BasePageObject {

    @FindBy(xpath = "//a[contains(text(),'Advanced Title Search')]")
    private WebElementFacade advanceTitleSearch;

    @FindBy(xpath = "//label[contains(text(),'Top 250')]")
    private WebElementFacade checkBoxToSelectTop250;

    @FindBy(xpath = "//select[@id='search-count']")
    private WebElementFacade select250Count;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElementFacade searchBtn;

    @FindBy(xpath = "//select[@name='sort']")
    private WebElementFacade sortDropDown;


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

    public void setResultLimit(String limit)
    {
        selectFromDrownDown(select250Count,limit);
    }

    public void setSortOrderZToA()
    {
        selectFromDrownDown(sortDropDown,"alpha,desc");
    }

    public void setSortOrderAToZ()
    {
        selectFromDrownDown(sortDropDown,"alpha,asc");
    }

    public void setRatingDesc(String val)
    {
        selectFromDrownDown(sortDropDown,val);
    }

    public void setRatingAsc(String val)
    {
        selectFromDrownDown(sortDropDown,val);
    }

    public void clickOnSearchBtn()
    {
        searchBtn.click();
    }

    public void userNavigateBack()
    {
        getDriver().navigate().back();
    }

}
