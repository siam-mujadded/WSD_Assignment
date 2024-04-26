import java.util.List;

public class Movie implements Comparable<Movie>{
    private String title;
    private String category;
    private int releaseYear;
    private double budget;
    private List<String> cast;


    public Movie(String title, String category, int releaseYear, double budget, List<String> cast) {
        this.title = title;
        this.category = category;
        this.releaseYear = releaseYear;
        this.budget = budget;
        this.cast = cast;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", releaseYear=" + releaseYear +
                ", budget=" + budget +
                ", cast=" + cast +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }

}
