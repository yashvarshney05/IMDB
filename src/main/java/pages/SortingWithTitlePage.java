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

public class SortingWithTitlePage extends BasePageObject {


    @FindBy(xpath = "//h3[@class='lister-item-header']/a")
     List<WebElementFacade> movieTitleInDefaultView;


    List<SortingDTO> actualTitleList = new ArrayList<SortingDTO>();

    public void sortMoviesByTitleLogicAtoZ()
    {
        for(int i=0;i<movieTitleInDefaultView.size();i++)
        {
            actualTitleList.add(new SortingDTO(movieTitleInDefaultView.get(i).getText()));
        }

        actualTitleList=actualTitleList.stream().sorted(Comparator.comparing(SortingDTO::getTitle)).collect(Collectors.toList());
        //for(int i=0;i<actualTitleList.size();i++)
           // System.out.println("Print int actual list=="+actualTitleList.get(i).getTitle());
    }

    public boolean verifySortedTitle()
    {
        for(int i=0;i<actualTitleList.size();i++)
        {
           // System.out.println("actualTitleList.get(i).getTitle()=="+actualTitleList.get(i).getTitle());
           // System.out.println("movieTitleInDefaultView.get(i).getText()=="+movieTitleInDefaultView.get(i).getText());
            if(!((actualTitleList.get(i).getTitle()).equals(movieTitleInDefaultView.get(i).getText())))
                return false;
        }
        return true;
    }


    public void userWriteCsv(String filePath)
    {
        FileUtils.writeCsv(filePath,movieTitleInDefaultView);

    }

    public void userWriteCSVWithClass(String filePath)
    {
        File file = new File(filePath);
        try {

            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            for(int i=0;i<actualTitleList.size();i++) {
                String[] a = {actualTitleList.get(i).getTitle()};
                writer.writeNext(a);
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
