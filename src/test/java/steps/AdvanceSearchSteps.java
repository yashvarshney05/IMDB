package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ImdbAdvanceSeachPage;

public class AdvanceSearchSteps extends ScenarioSteps {

    ImdbAdvanceSeachPage imdbAdvanceSeachPageObj;

    @Step("User click on top 250 check box")
    public void click_on_advance_title_search()
    {
        imdbAdvanceSeachPageObj.clickOnAdvanceTitleSearch();;
    }

    @Step("User clicks on check box")
    public void click_on_check_box()
    {
        imdbAdvanceSeachPageObj.clickOnCheckBoxToSelectTop250();
    }

    @Step("User click on search button")
    public void click_on_search_button()
    {
        imdbAdvanceSeachPageObj.clickOnSearchBtn();
    }
}
