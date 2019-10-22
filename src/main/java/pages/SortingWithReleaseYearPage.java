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

public class SortingWithReleaseYearPage extends BasePageObject {

    @FindBy(xpath = "//span[@class='lister-item-year text-muted unbold']")
    List<WebElementFacade> yearInDefaultView;

    @FindBy(xpath = "//h3[@class='lister-item-header']/a")
    List<WebElementFacade> movieTitleInDefaultView;

    @FindBy(xpath = "//div[@class='ratings-bar']//strong")
    List<WebElementFacade> ratingDefaultView;

    List<SortingDTO> actualYearList = new ArrayList<SortingDTO>();

    public void sortMoviesByYearLogicAtoZ()
    {
        for(int i=0;i<yearInDefaultView.size();i++)
        {
            actualYearList.add(new SortingDTO(yearInDefaultView.get(i).getText(),movieTitleInDefaultView.get(i).getText(),ratingDefaultView.get(i).getText()));
        }

        actualYearList = actualYearList.stream()
                .sorted(Comparator.comparing(SortingDTO::getYear)
                        .thenComparing(Comparator.comparing(SortingDTO::getTitle))
                        .thenComparing(Comparator.comparing(SortingDTO::getRating))

                )
                .collect(Collectors.toList());

    }

    public boolean verifySortedYear()
    {
        System.out.println("!!!!!!!!!!!!Inside list verification!!!!!!!!!!!!!!");
        for(int i=0;i<actualYearList.size();i++)
        {
            if(!((actualYearList.get(i).getYear()).equals((yearInDefaultView.get(i).getText()))));
                return false;
        }
        return true;
    }

    //This method print the values generated on run time sorted values by system
    public void userWriteCsv(String filePath)
    {
        FileUtils.writeCsv(filePath,movieTitleInDefaultView,yearInDefaultView);

    }

    //This method runs for user generated sorting logic
    public void userWriteCSVWithClass(String filePath)
    {
        File file = new File(filePath);
        try {

            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            for(int i=0;i<actualYearList.size();i++) {
                System.out.println("actualYearList.get(i).getYear()=="+actualYearList.get(i).getYear()+"actualYearList.get(i).getTitle()=="+actualYearList.get(i).getTitle());
                String[] a = {actualYearList.get(i).getTitle(),actualYearList.get(i).getYear()};
                writer.writeNext(a);
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
