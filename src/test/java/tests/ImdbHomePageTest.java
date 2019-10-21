package tests;

import common.BaseCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.ImdbHomePageSteps;
import utils.CommonUtils;

public class ImdbHomePageTest extends BaseCase {

    @Steps
    ImdbHomePageSteps imdbHomePageStepsObj;

    @Test
    public void verify_sort_scenario()
    {
        String home_page_url = CommonUtils.getBaseUrl();
        imdbHomePageStepsObj.web_page_is_opened(home_page_url);
        imdbHomePageStepsObj.verify_imdb_icon_is_appeared();
    }

}
