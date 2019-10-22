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

}
