package steps;

import core.BasePageObject;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ImdbHomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ImdbHomePageSteps extends ScenarioSteps {

    private ImdbHomePage imdbHomePageObj;
    private BasePageObject basePageObj;

    @Step("User opens imdb website")
    public void web_page_is_opened(String url)
    {
         basePageObj.openPageUrl(url);
    }

    @Step("Verify page is loaded and IMDB icon is appeared")
    public void verify_imdb_icon_is_appeared()
    {
        assertThat(imdbHomePageObj.verifyImdbIconIsDisplayed()).overridingErrorMessage("Home page is not loaded").isTrue();
    }

    @Step("User click on advanced search box")
    public void click_on_advanced_search()
    {
        imdbHomePageObj.userClickOnAdvancedSearch();
    }




}
