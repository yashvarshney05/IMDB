package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SortingPage;

public class SortingSteps extends ScenarioSteps {

   private SortingPage sortingPageObj;

    @Step("User clicks on sort by title Ascending order")
    public void clickOnSortByTitleAToZ()
    {
        sortingPageObj.sortMoviesByTitleAToZ();
    }

    @Step("User writes csv")
    public void writeCsv(String filePath)
    {
        sortingPageObj.userWriteCsv(filePath);
    }
}
