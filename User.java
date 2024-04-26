import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<Movie> favorites;

    public User(String email) {
        this.email = email;
        favorites = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void addFavorite(Movie movie) {
        favorites.add(movie);
    }

    public void removeFavorite(Movie movie) {
        favorites.remove(movie);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", favorites=" + favorites +
                '}';
    }

    public List<Movie> getFavorites() {
        return favorites;
    }



}
