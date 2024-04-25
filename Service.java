import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Service {
    private List<Movie> movies;
    private HashMap<String, User> users;
    private User currentUser;

    public Service(List<Movie> movies) {
        this.movies = movies;
        this.users = new HashMap<>();
    }

    public Service() {
        this.movies = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void addUser(String email) {
        users.put(email, new User(email));
    }

    public void setCurrentUser(String email) {
        if (!users.containsKey(email)) {
            users.put(email, new User(email));
        }
        currentUser = users.get(email);
    }

    public void logout() {
        currentUser = null;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void searchByTitle(int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        String title = takeInput("Enter the title:");
        title = title.toLowerCase();
        System.out.println("Results for title " + title + ":");
        for (Movie movie : searchlist) {
            if (movie.getTitle().toLowerCase().equals(title)) {
                System.out.println(movie);
            }
        }
    }

    private String takeInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void searchByCategory(int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        String category = takeInput("Enter the category:");
        category = category.toLowerCase();
        System.out.println("Results for category " + category + ":");
        for (Movie movie : searchlist) {
            if (movie.getCategory().toLowerCase().equals(category)) {
                System.out.println(movie);
            }
        }
    }

    public void searchByCast(int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        String castMember = takeInput("Enter the cast member:");
        castMember = castMember.toLowerCase();
        System.out.println("Results for cast member " + castMember + ":");
        for (Movie movie : searchlist) {
            if (movie.getCast().contains(castMember)) {
                System.out.println(movie);
            }
        }
    }

    public List<String> takeMultipleInput() {
        System.out.print("Enter the number of cast members: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> castMembers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter cast member " + (i + 1) + ": ");
            castMembers.add(scanner.nextLine().toLowerCase());
        }
        return castMembers;
    }

    public void searchByMultipleCastMembers(int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        List<String> castMembers = takeMultipleInput();
        System.out.println("Results for cast members " + castMembers + ":");
        for (Movie movie : searchlist) {
            if (movie.getCast().containsAll(castMembers)) {
                System.out.println(movie);
            }
        }
    }

    public void searchByYear(int year, int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        System.out.println("Results for year " + year + ":");
        for (Movie movie : searchlist) {
            if (movie.getReleaseYear() == year) {
                System.out.println(movie);
            }
        }
    }

    public void printMovies() {
        System.out.println("Movies:");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
        System.out.println();
    }

    public void getDetails() {
        printMovies();
        System.out.print("Enter the title of the movie to get details: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println();
        title = title.toLowerCase();

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().equals(title)) {
                System.out.println(movie);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public void addToFavorites() {
        printMovies();
        System.out.print("Enter the title of the movie to add to favorites: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println();
        title = title.toLowerCase();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().equals(title)) {
                currentUser.addFavorite(movie);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public void removeFromFavorites() {
        List<Movie> favorites = currentUser.getFavorites();
        if (favorites.isEmpty()) {
            System.out.println("No favorites to remove.");
            return;
        }
        System.out.println("Favorites:");
        for (Movie movie : favorites) {
            System.out.println(movie.getTitle());
        }
        System.out.print("Enter the title of the movie to remove from favorites: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println();
        title = title.toLowerCase();
        for (Movie movie : favorites) {
            if (movie.getTitle().toLowerCase().equals(title)) {
                currentUser.removeFavorite(movie);
                return;
            }
        }
        System.out.println("Favorite not found.");
    }

    public void seeDetailsOfUser() {
        System.out.println(currentUser);
    }


}
