package pages;


import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingPage extends BasePageObject {


    @FindBy(xpath = "//h3[@class='lister-item-header']/a")
     List<WebElementFacade> movieTitleInDefaultView;

     @FindBy(linkText = "A-Z")
     WebElementFacade sortByTitleLink;


    //ArrayList<SortingLogic> dataAsDisplayedInDefaultView;

    //ArrayList<SortingLogic> expectedOrder=dataAsDisplayedInDefaultView;

    public ArrayList<SortingLogic> getLatestMovieReleaseDisplayed() {

        ArrayList<SortingLogic> LatestMovieReleaseDisplayed=new ArrayList<SortingLogic>();
            LatestMovieReleaseDisplayed.add(new SortingLogic(movieTitleInDefaultView) );

        return LatestMovieReleaseDisplayed;
    }


    public void sortMoviesByTitle()
    {

        for(int i=0;i<movieTitleInDefaultView.size();i++) {
            System.out.println("Before sorting=="+movieTitleInDefaultView.get(i).getText());

        }

            sortByTitleLink.waitUntilEnabled().expect("Element should be enabled").isEnabled();
            sortByTitleLink.click();


        Collections.sort(getLatestMovieReleaseDisplayed(), SortingLogic.SORT_TITLE_ASCENDING);

        for(int i=0;i<movieTitleInDefaultView.size();i++)
            System.out.println("After sorting"+movieTitleInDefaultView.get(i).getText());


    }
}
