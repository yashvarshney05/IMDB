package tests;

import common.BaseCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.AdvanceSearchSteps;
import steps.ImdbHomePageSteps;
import steps.SortingSteps;
import utils.CommonUtils;

public class ImdbHomePageTest extends BaseCase {

    @Steps
    ImdbHomePageSteps imdbHomePageStepsObj;

    @Steps
    AdvanceSearchSteps advanceSearchStepsObj;

    @Steps
    SortingSteps sortingStepsObj;

    @Test
    public void verify_sort_scenario()
    {
        String value="/search/";
        String home_page_url = CommonUtils.getBaseUrl();
        imdbHomePageStepsObj.web_page_is_opened(home_page_url);
        imdbHomePageStepsObj.verify_imdb_icon_is_appeared();
        imdbHomePageStepsObj.click_on_advanced_search(value);
        advanceSearchStepsObj.click_on_advance_title_search();
        advanceSearchStepsObj.click_on_check_box();
        advanceSearchStepsObj.click_on_search_button();
        sortingStepsObj.clickOnSortByTitle();
    }

}
