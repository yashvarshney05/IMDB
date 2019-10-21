package pages;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingLogic implements Comparable<SortingLogic>{

    String title;
    String rating;
    String year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public SortingLogic(String title)
    {
        this.title=title;

    }
   public SortingLogic(String title, String rating, String year)
    {
        this.title=title;
        this.rating=rating;
        this.year=year;
    }

    public int compareTo(SortingLogic s)
    {
        return getTitle().compareTo(s.getTitle());
    }

  /* public static final Comparator<SortingLogic> SORT_YEAR_ASCENDING =  new Comparator<SortingLogic>(){
        public int compare(SortingLogic o1, SortingLogic o2) {
            int result = o1.getYear().compareTo(o2.getYear());
            return (result);
        }
    };

     static final Comparator<SortingLogic> SORT_TITLE_ASCENDING =  new Comparator<SortingLogic>(){
        public int compare(SortingLogic o1, SortingLogic o2) {
            int result = o1.getTitle().compareTo(o2.getTitle());
            return (result);
        }
    };

    static final Comparator<SortingLogic> SORT_TITLE_DESCENDING =  new Comparator<SortingLogic>(){
        public int compare(SortingLogic o1, SortingLogic o2) {
            int result = o2.getTitle().compareTo(o1.getTitle());
            return (result);
        }
    };

    static final Comparator<SortingLogic> SORT_RATING_ASCENDING =  new Comparator<SortingLogic>(){
        public int compare(SortingLogic o1, SortingLogic o2) {
            int result = o1.getRating().compareTo(o2.getRating());
            return (result);
        }
    }; */


}
