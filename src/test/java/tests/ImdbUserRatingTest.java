package tests;

import common.BaseCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.*;
import utils.CommonUtils;


public class ImdbUserRatingTest extends BaseCase {

    @Steps
    ImdbHomePageSteps imdbHomePageStepsObj;

    @Steps
    AdvanceSearchSteps advanceSearchStepsObj;

    @Steps
    SortingWithUserRatingSteps sortingWithUserRatingStepsObj;

    @Test
    public void verify_sort_by_user_rating()
    {
        System.out.println("!!!!!!!!Inside sort by Rating!!!!!!!!!!!!!");
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
        sortingWithUserRatingStepsObj.sort_using_rating();
        sortingWithUserRatingStepsObj.writeCsvWithClass(beforeSortingFilePath);


        //User navigate back & reset title search in ascending order
        advanceSearchStepsObj.user_navigate_back();
        advanceSearchStepsObj.set_user_rating_asc(rating_val_asc);
        advanceSearchStepsObj.click_on_search_button();
        sortingWithUserRatingStepsObj.writeCsv(afterSortingFilePath);

        sortingWithUserRatingStepsObj.verify_rating_list_comparison();
    }
}
