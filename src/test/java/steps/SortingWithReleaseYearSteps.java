package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SortingWithReleaseYear;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingWithReleaseYearSteps extends ScenarioSteps {

     SortingWithReleaseYear sortingWithReleaseYearObj;

    @Step("User clicks on sort by year Ascending order")
    public void sort_using_year()
    {
        sortingWithReleaseYearObj.sortMoviesByYearLogicAtoZ();
    }

    @Step("Verifying the list comparison")
    public void verify_year_list_comparison()
    {
        assertThat(sortingWithReleaseYearObj.verifySortedYear()).overridingErrorMessage("There is bug in sorted year").isTrue();
    }

    @Step("User writes csv")
    public void writeCsv(String filePath)
    {
        sortingWithReleaseYearObj.userWriteCsv(filePath);

    }

    @Step("User write csv using class name")
    public void writeCsvWithClass(String filePath)
    {
        sortingWithReleaseYearObj.userWriteCSVWithClass(filePath);
    }

}
