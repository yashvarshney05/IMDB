package steps;

import core.BasePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.HomePage;

public class SuccessCreditScenarioSteps extends ScenarioSteps {

    private BasePageObject basePageObj;
    private HomePage homePageObj;


    @Step("Open home page")
    public void open_home_page(String url)
    {
        basePageObj.openUrl(url);
    }

    @Step("User click on Buy Now Button")
    public void user_on_click_buy_now()
    {
        homePageObj.clickOnBuyNow();
    }

}
