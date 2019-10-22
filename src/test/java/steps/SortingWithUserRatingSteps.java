package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SortingWithUserRatingPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingWithUserRatingSteps extends ScenarioSteps {

    private SortingWithUserRatingPage sortingWithUserRatingPageObj;

    @Step("User clicks on sort by rating Ascending order")
    public void sort_using_rating()
    {
        sortingWithUserRatingPageObj.sortMoviesByRatingLogicAtoZ();
    }

    @Step("Verifying the list comparison")
    public void verify_rating_list_comparison()
    {
        assertThat(sortingWithUserRatingPageObj.verifySortedRating()).overridingErrorMessage("There is bug in sorted rating").isTrue();
    }

    @Step("User writes csv")
    public void writeCsv(String filePath)
    {
        sortingWithUserRatingPageObj.userWriteCsv(filePath);

    }

    @Step("User write csv using class name")
    public void writeCsvWithClass(String filePath)
    {
        sortingWithUserRatingPageObj.userWriteCSVWithClass(filePath);
    }
}
