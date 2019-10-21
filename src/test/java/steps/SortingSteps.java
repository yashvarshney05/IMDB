package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SortingPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingSteps extends ScenarioSteps {

   private SortingPage sortingPageObj;

    @Step("User clicks on sort by title Ascending order")
    public void sortUsingLogic()
    {
        sortingPageObj.sortMoviesByTitleLogicAtoZ();
    }

    @Step("Verifying the list comparison")
    public void verify_title_list_comparison()
    {
         assertThat(sortingPageObj.verifySortedTitle()).overridingErrorMessage("There is bug in sorting").isTrue();
    }

    @Step("User writes csv")
    public void writeCsv(String filePath)
    {
        sortingPageObj.userWriteCsv(filePath);

    }

    @Step("User write csv using class name")
    public void writeCsvWithClass(String filePath)
    {
        sortingPageObj.userWriteCSVWithClass(filePath);
    }
}
