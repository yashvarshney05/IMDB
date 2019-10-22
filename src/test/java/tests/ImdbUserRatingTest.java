package tests;

import common.BaseCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import pages.SortingWithReleaseYear;
import steps.*;
import utils.CommonUtils;


public class ImdbUserRatingTest extends BaseCase {

    @Steps
    ImdbHomePageSteps imdbHomePageStepsObj;

    @Steps
    AdvanceSearchSteps advanceSearchStepsObj;

    @Steps
    SortingWithReleaseYearSteps sortingWithReleaseYearStepsObj;

    @Test
    public void verify_sort_by_user_rating()
    {
        String value="/search/";
        String limit="250";
        String rating_val_desc="user_rating,desc";
        String rating_val_asc="user_rating,asc";
        String beforeSortingFilePath="reports/beforeRatingSortingAsc.csv";
        String afterSortingFilePath="reports/afterRatingSortingAsc.csv";
        String home_page_url = CommonUtils.getBaseUrl();
        imdbHomePageStepsObj.web_page_is_opened(home_page_url);
        imdbHomePageStepsObj.verify_imdb_icon_is_appeared();
        imdbHomePageStepsObj.click_on_advanced_search(value);
        advanceSearchStepsObj.click_on_advance_title_search();
        advanceSearchStepsObj.click_on_check_box();
        advanceSearchStepsObj.set_result_limit(limit);
        // get a list of 250 mov ues in descending order
        advanceSearchStepsObj.set_user_rating_desc(rating_val_desc);
        advanceSearchStepsObj.click_on_search_button();
        sortingWithReleaseYearStepsObj.sort_using_year();
        sortingWithReleaseYearStepsObj.writeCsvWithClass(beforeSortingFilePath);


        //User navigate back & reset title search in ascending order
        advanceSearchStepsObj.user_navigate_back();
        advanceSearchStepsObj.set_user_rating_asc(rating_val_asc);
        advanceSearchStepsObj.click_on_search_button();
        sortingWithReleaseYearStepsObj.writeCsv(afterSortingFilePath);

        sortingWithReleaseYearStepsObj.verify_year_list_comparison();
    }
}
