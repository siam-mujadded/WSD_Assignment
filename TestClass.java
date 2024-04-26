import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    Service service = new Service();

    @BeforeEach
    public void setUp() {
        String email = "abc@gmail.com";
        service.setCurrentUser(email);
        service.clearMovies();
    }


    @Test
    @DisplayName("Test registration")
    public void testRegistration() {
        String email = "abc@gmail.com";
        service.setCurrentUser(email);
        assertEquals(email, service.getCurrentUser().getEmail(),
                "Registration failed.");
    }

    @Test
    @DisplayName("Test logout")
    public void testLogout() {
        System.out.println("Current user: "+service.getCurrentUser().getEmail());
        service.logout();
        assertEquals(null, service.getCurrentUser(),
                "Logout failed.");
    }

    @Test
    @DisplayName("Test search by title")
    public void testSearchByTitle() {
        Movie Godfather1 = new Movie("The Godfather", "Crime", 1972, 6.5, List.of("Marlon Brando", "Al Pacino"));
        Movie Godfather2 = new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro"));
        Movie lotr1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure", 2001, 93, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr2 = new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr3 = new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen"));

        ArrayList<Movie> expected1 = new ArrayList<>();
        expected1.addAll(List.of(Godfather1, Godfather2, lotr1, lotr2, lotr3));
        ArrayList<Movie> expected2 = new ArrayList<>();
        expected2.addAll(List.of(Godfather1, Godfather2));
        ArrayList<Movie> expected3 = new ArrayList<>();
        expected3.addAll(List.of(lotr1, lotr2, lotr3));

        expected1.sort(Movie::compareTo);
        expected2.sort(Movie::compareTo);
        expected3.sort(Movie::compareTo);

        service.addMovie(Godfather1);
        service.addMovie(Godfather2);
        service.addMovie(lotr1);
        service.addMovie(lotr2);
        service.addMovie(lotr3);

        List<Movie> result1 = service.searchByTitle(1, "The");
        List<Movie> result2 = service.searchByTitle(1, "Godfather");
        List<Movie> result3 = service.searchByTitle(1, "Lord");

        assertEquals(expected1, result1, "Search by title failed.");
        assertEquals(expected2, result2, "Search by title failed.");
        assertEquals(expected3, result3, "Search by title failed.");
    }

    @Test
    @DisplayName("Test search by category")
    public void testSearchByCategory() {
        Movie Godfather1 = new Movie("The Godfather", "Crime", 1972, 6.5, List.of("Marlon Brando", "Al Pacino"));
        Movie Godfather2 = new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro"));
        Movie lotr1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure", 2001, 93, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr2 = new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr3 = new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen"));

        ArrayList<Movie> expected1 = new ArrayList<>();
        expected1.addAll(List.of(Godfather1, Godfather2));
        ArrayList<Movie> expected2 = new ArrayList<>();
        expected2.addAll(List.of(lotr1, lotr2, lotr3));

        expected1.sort(Movie::compareTo);
        expected2.sort(Movie::compareTo);

        service.addMovie(Godfather1);
        service.addMovie(Godfather2);
        service.addMovie(lotr1);
        service.addMovie(lotr2);
        service.addMovie(lotr3);

        List<Movie> result1 = service.searchByCategory(1, "Crime");
        List<Movie> result2 = service.searchByCategory(1, "Adventure");

        assertEquals(expected1, result1, "Search by category failed.");
        assertEquals(expected2, result2, "Search by category failed.");
    }

    @Test
    @DisplayName("Test search by cast name")
    public void testSearchByCast() {
        Movie Godfather1 = new Movie("The Godfather", "Crime", 1972, 6.5, List.of("Marlon Brando", "Al Pacino"));
        Movie Godfather2 = new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro"));
        Movie lotr1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure", 2001, 93, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr2 = new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr3 = new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen"));

        ArrayList<Movie> expected1 = new ArrayList<>();
        expected1.addAll(List.of(Godfather1, Godfather2));
        ArrayList<Movie> expected2 = new ArrayList<>();
        expected2.addAll(List.of(lotr1, lotr2));

        expected1.sort(Movie::compareTo);
        expected2.sort(Movie::compareTo);

        service.addMovie(Godfather1);
        service.addMovie(Godfather2);
        service.addMovie(lotr1);
        service.addMovie(lotr2);
        service.addMovie(lotr3);

        List<Movie> result1 = service.searchByCast(1, "Al Pacino");
        List<Movie> result2 = service.searchByCast(1, "Ian McKellen");

        assertEquals(expected1, result1, "Search by cast name failed.");
        assertEquals(expected2, result2, "Search by cast name failed.");
    }

    @Test
    @DisplayName("Test add movies to the favorites")
    public void testAddMoviesToFavorites() {
        Movie Godfather1 = new Movie("The Godfather", "Crime", 1972, 6.5, List.of("Marlon Brando", "Al Pacino"));
        Movie Godfather2 = new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro"));
        Movie lotr1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure", 2001, 93, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr2 = new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr3 = new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen"));

        ArrayList<Movie> expected = new ArrayList<>();
        expected.addAll(List.of(Godfather1, lotr1));
        expected.sort(Movie::compareTo);

        service.addMovie(Godfather1);
        service.addMovie(Godfather2);
        service.addMovie(lotr1);
        service.addMovie(lotr2);
        service.addMovie(lotr3);
        service.addToFavorites("The Godfather");
        service.addToFavorites("The Lord of the Rings: The Fellowship of the Ring");
        List<Movie> result = service.getFavorites();

        assertEquals(expected, result, "Add to favorites failed.");
    }

    @Test
    @DisplayName("Testing remove movies from favorites")
    public void testRemoveFromFavorites() {
        Movie Godfather1 = new Movie("The Godfather", "Crime", 1972, 6.5, List.of("Marlon Brando", "Al Pacino"));
        Movie Godfather2 = new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro"));
        Movie lotr1 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure", 2001, 93, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr2 = new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen"));
        Movie lotr3 = new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen"));

        ArrayList<Movie> expected = new ArrayList<>();
        expected.addAll(List.of(Godfather1, lotr1));
        expected.sort(Movie::compareTo);

        service.addMovie(Godfather1);
        service.addMovie(Godfather2);
        service.addMovie(lotr1);
        service.addMovie(lotr2);
        service.addMovie(lotr3);
        service.addToFavorites("The Godfather");
        service.addToFavorites("The Lord of the Rings: The Fellowship of the Ring");
        List<Movie> result = service.getFavorites();

        assertEquals(expected, result, "Add to favorites failed.");

        ArrayList<Movie> expected2 = new ArrayList<>();
        expected2.addAll(List.of(lotr1));
        expected2.sort(Movie::compareTo);

        service.removeFromFavorites("The Godfather");
        List<Movie> result2 = service.getFavorites();

        assertEquals(expected2, result2, "Remove from favorites failed.");
    }
}
