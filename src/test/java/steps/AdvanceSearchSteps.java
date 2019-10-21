package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ImdbAdvanceSearchPage;

public class AdvanceSearchSteps extends ScenarioSteps {

    ImdbAdvanceSearchPage imdbAdvanceSeachPageObj;

    @Step("User click on top 250 check box")
    public void click_on_advance_title_search()
    {
        imdbAdvanceSeachPageObj.clickOnAdvanceTitleSearch();
    }

    @Step("User clicks on check box")
    public void click_on_check_box()
    {
        imdbAdvanceSeachPageObj.clickOnCheckBoxToSelectTop250();
    }

    @Step("User set result limit for 250")
    public void set_result_limit(String limit)
    {
        imdbAdvanceSeachPageObj.setResultLimit(limit);
    }

    @Step("User set default display order Z-A")
    public void set_display_order_ZToA()
    {
        imdbAdvanceSeachPageObj.setSortOrderZToA();
    }

    @Step("User set default display order A-Z")
    public void set_display_order_AToZ()
    {
        imdbAdvanceSeachPageObj.setSortOrderAToZ();
    }

    @Step("User click on search button")
    public void click_on_search_button()
    {
        imdbAdvanceSeachPageObj.clickOnSearchBtn();
    }

    @Step("User navigate back")
    public void user_navigate_back()
    {
        imdbAdvanceSeachPageObj.userNavigateBack();
    }



}
