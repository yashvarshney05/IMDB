package pages;


import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingPage extends BasePageObject {


    @FindBy(xpath = "//h3[@class='lister-item-header']/a")
     List<WebElementFacade> movieTitleInDefaultView;

     @FindBy(linkText = "A-Z")
     WebElementFacade sortByTitleLink;

    public ArrayList<SortingLogic> getLatestMovieReleaseDisplayed() {

        ArrayList<SortingLogic> LatestMovieReleaseDisplayed=new ArrayList<SortingLogic>();
            LatestMovieReleaseDisplayed.add(new SortingLogic(movieTitleInDefaultView) );

        return LatestMovieReleaseDisplayed;
    }


    public void sortMoviesByTitleAToZ()
    {

        Collections.sort(getLatestMovieReleaseDisplayed(), SortingLogic.SORT_TITLE_ASCENDING);
    }

    public void userWriteCsv(String filePath)
    {
        CommonUtils.writeCsv(filePath,movieTitleInDefaultView);

    }
}
