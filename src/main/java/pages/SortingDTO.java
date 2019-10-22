package pages;

public class SortingDTO implements Comparable<SortingDTO>{

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


    public SortingDTO(String title)
    {
        this.title=title;

    }

    public SortingDTO(String title, String rating)
    {
        this.title=title;
        this.rating=rating;

    }


    public SortingDTO(String title, String rating, String year)
    {
        this.title=title;
        this.rating=rating;
        this.year=year;
    }

    public int compareTo(SortingDTO s)
    {
        return getTitle().compareTo(s.getTitle());
    }

  /* public static final Comparator<SortingDTO> SORT_YEAR_ASCENDING =  new Comparator<SortingDTO>(){
        public int compare(SortingDTO o1, SortingDTO o2) {
            int result = o1.getYear().compareTo(o2.getYear());
            return (result);
        }
    };

     static final Comparator<SortingDTO> SORT_TITLE_ASCENDING =  new Comparator<SortingDTO>(){
        public int compare(SortingDTO o1, SortingDTO o2) {
            int result = o1.getTitle().compareTo(o2.getTitle());
            return (result);
        }
    };

    static final Comparator<SortingDTO> SORT_TITLE_DESCENDING =  new Comparator<SortingDTO>(){
        public int compare(SortingDTO o1, SortingDTO o2) {
            int result = o2.getTitle().compareTo(o1.getTitle());
            return (result);
        }
    };

    static final Comparator<SortingDTO> SORT_RATING_ASCENDING =  new Comparator<SortingDTO>(){
        public int compare(SortingDTO o1, SortingDTO o2) {
            int result = o1.getRating().compareTo(o2.getRating());
            return (result);
        }
    }; */


}
