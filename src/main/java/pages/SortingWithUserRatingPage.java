package pages;

import au.com.bytecode.opencsv.CSVWriter;
import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.CommonUtils;
import utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingWithUserRatingPage extends BasePageObject {

    @FindBy(xpath = "//h3[@class='lister-item-header']/a")
    List<WebElementFacade> movieTitleInDefaultView;

    @FindBy(xpath = "//div[@class='ratings-bar']//strong")
    List<WebElementFacade> ratingDefaultView;

    @FindBy(xpath = "//span[@class='lister-item-year text-muted unbold']")
    List<WebElementFacade> yearInDefaultView;

    List<SortingDTO> actualTitleAndRatingList = new ArrayList<SortingDTO>();

    public void sortMoviesByRatingLogicAtoZ()
    {
        for(int i=0;i<movieTitleInDefaultView.size();i++)
        {

            actualTitleAndRatingList.add(new SortingDTO(ratingDefaultView.get(i).getText(),movieTitleInDefaultView.get(i).getText(),yearInDefaultView.get(i).getText()));
        }

        actualTitleAndRatingList = actualTitleAndRatingList.stream()
                .sorted(Comparator.comparing(SortingDTO::getRating)
                        .thenComparing(Comparator.comparing(SortingDTO::getTitle))
                        .thenComparing(Comparator.comparing(SortingDTO::getYear))
                )
                .collect(Collectors.toList());

        for(int i=0;i<actualTitleAndRatingList.size();i++)
            System.out.println("actualTitleAndRatingList.get(i).getRating()=="+actualTitleAndRatingList.get(i).getRating()+"actualTitleAndRatingList.get(i).getRating()===="+actualTitleAndRatingList.get(i).getTitle());

    }

    public boolean verifySortedRating()
    {
        for(int i=0;i<actualTitleAndRatingList.size();i++)
        {
            System.out.println("actualTitleAndRatingList.get(i).getRating()=="+actualTitleAndRatingList.get(i).getRating());
            System.out.println("actualTitleAndRatingList.get(i).getTitle()=="+actualTitleAndRatingList.get(i).getTitle());
            if(!((actualTitleAndRatingList.get(i).getRating()).equals(ratingDefaultView.get(i).getText())))
                return false;
        }
        return true;
    }

    public void userWriteCsv(String filePath)
    {
        FileUtils.writeCsv(filePath,movieTitleInDefaultView,ratingDefaultView);

    }

    //This is after method
    public void userWriteCSVWithClass(String filePath)
    {
        File file = new File(filePath);
        try {

            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            for(int i=0;i<actualTitleAndRatingList.size();i++) {
                String[] a = {actualTitleAndRatingList.get(i).getRating(),actualTitleAndRatingList.get(i).getTitle()};
                writer.writeNext(a);
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
