package utils;

import au.com.bytecode.opencsv.CSVWriter;
import net.serenitybdd.core.pages.WebElementFacade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    public static void writeCsv(String filePath, List<WebElementFacade> data) {
        File file = new File(filePath);
        try {

            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            for (int i = 0; i < data.size(); i++) {
                String[] a = {data.get(i).getText()};
                writer.writeNext(a);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCsv(String filePath, List<WebElementFacade> title,List<WebElementFacade> rating) {
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            for (int i = 0; i < title.size(); i++) {
               // System.out.println("title.get(i).getText()==="+title.get(i).getText()+"rating.get(i).getText()=="+rating.get(i).getText());

                String[] a = {title.get(i).getText(),rating.get(i).getText()};
                writer.writeNext(a);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
