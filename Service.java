import java.util.*;


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

    public User getCurrentUser() {
        return currentUser;
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
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getTitle().toLowerCase().contains(title)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        for (Movie movie : results) {
            System.out.println(movie);
        }
    }

    public List<Movie> searchByTitle(int choice, String title) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        title = title.toLowerCase();
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getTitle().toLowerCase().contains(title)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        return results;
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
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getCategory().toLowerCase().equals(category)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        for (Movie movie : results) {
            System.out.println(movie);
        }
    }

    public List<Movie> searchByCategory(int choice, String category) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        category = category.toLowerCase();
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getCategory().toLowerCase().equals(category)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        return results;
    }

    public void searchByCast(int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        String castMember = takeInput("Enter the cast member:");
        System.out.println("Results for cast member " + castMember + ":");
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getCast().contains(castMember)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        for (Movie movie : results) {
            System.out.println(movie);
        }
    }

    public List<Movie> searchByCast(int choice, String castMember) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getCast().contains(castMember)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        return results;
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
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getCast().containsAll(castMembers)) {
                results.add(movie);
            }
        }
        results.sort(Comparator.comparing(Movie::getTitle));
        for (Movie movie : results) {
            System.out.println(movie);
        }
    }

    public void searchByYear(int year, int choice) {
        List<Movie> searchlist;
        if (choice == 1) searchlist = movies;
        else searchlist = currentUser.getFavorites();
        System.out.println("Results for year " + year + ":");
        List<Movie> results = new ArrayList<>();
        for (Movie movie : searchlist) {
            if (movie.getReleaseYear() == year) {
                results.add(movie);
            }
        }

        results.sort(Comparator.comparing(Movie::getTitle));
        for (Movie movie : results) {
            System.out.println(movie);
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

    public void addToFavorites(String title) {
        title = title.toLowerCase();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().equals(title)) {
                currentUser.addFavorite(movie);
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public List<Movie> getFavorites() {
        currentUser.getFavorites().sort(Movie::compareTo);
        return currentUser.getFavorites();
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

    public void removeFromFavorites(String title) {
        List<Movie> favorites = currentUser.getFavorites();
        if (favorites.isEmpty()) {
            System.out.println("No favorites to remove.");
            return;
        }

        for (Movie movie : favorites) {
            System.out.println(movie.getTitle());
        }
        title = title.toLowerCase();
        for (Movie movie : favorites) {
            if (movie.getTitle().toLowerCase().equals(title)) {
                currentUser.removeFavorite(movie);
                return;
            }
        }
    }

    public void seeDetailsOfUser() {
        System.out.println(currentUser);
    }


    public void clearMovies() {
        movies.clear();
    }
}
