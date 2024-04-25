import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addMovie(new Movie("The Godfather", "Crime", 1972, 6.5, List.of("Marlon Brando", "Al Pacino")));
        service.addMovie(new Movie("The Shawshank Redemption", "Drama", 1994, 25, List.of("Tim Robbins", "Morgan Freeman")));
        service.addMovie(new Movie("The Dark Knight", "Action", 2008, 185, List.of("Christian Bale", "Heath Ledger")));
        service.addMovie(new Movie("Forrest Gump", "Drama", 1994, 55, List.of("Tom Hanks", "Robin Wright")));
        service.addMovie(new Movie("Inception", "Action", 2010, 160, List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt")));
        service.addMovie(new Movie("The Matrix", "Action", 1999, 63, List.of("Keanu Reeves", "Laurence Fishburne")));
        service.addMovie(new Movie("The Lord of the Rings: The Fellowship of the Ring", "Adventure", 2001, 93, List.of("Elijah Wood", "Ian McKellen")));
        service.addMovie(new Movie("The Lion King", "Animation", 1994, 45, List.of("Matthew Broderick", "Jeremy Irons")));
        service.addMovie(new Movie("The Avengers", "Action", 2012, 220, List.of("Robert Downey Jr.", "Chris Evans")));
        service.addMovie(new Movie("The Wolf of Wall Street", "Biography", 2013, 100, List.of("Leonardo DiCaprio", "Jonah Hill")));
        service.addMovie(new Movie("The Social Network", "Biography", 2010, 40, List.of("Jesse Eisenberg", "Andrew Garfield")));
        service.addMovie(new Movie("The Pursuit of Happyness", "Biography", 2006, 21, List.of("Will Smith", "Jaden Smith")));
        service.addMovie(new Movie("The Grand Budapest Hotel", "Comedy", 2014, 25, List.of("Ralph Fiennes", "F. Murray Abraham")));
        service.addMovie(new Movie("The Hangover", "Comedy", 2009, 35, List.of("Bradley Cooper", "Zach Galifianakis")));
        service.addMovie(new Movie("The Incredibles", "Animation", 2004, 92, List.of("Craig T. Nelson", "Holly Hunter")));
        service.addMovie(new Movie("The Dark Knight Rises", "Action", 2012, 230, List.of("Christian Bale", "Tom Hardy")));
        service.addMovie(new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen")));
        service.addMovie(new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen")));
        service.addMovie(new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro")));
        service.addMovie(new Movie("The Silence of the Lambs", "Crime", 1991, 19, List.of("Jodie Foster", "Anthony Hopkins")));
        service.addMovie(new Movie("The Departed", "Crime", 2006, 90, List.of("Leonardo DiCaprio", "Matt Damon")));
        service.addMovie(new Movie("The Prestige", "Drama", 2006, 40, List.of("Christian Bale", "Hugh Jackman")));
        service.addMovie(new Movie("The Green Mile", "Drama", 1999, 60, List.of("Tom Hanks", "Michael Clarke Duncan")));
        service.addMovie(new Movie("The Intouchables", "Drama", 2011, 13, List.of("François Cluzet", "Omar Sy")));
        service.addMovie(new Movie("The Pianist", "Drama", 2002, 35, List.of("Adrien Brody", "Thomas Kretschmann")));
        service.addMovie(new Movie("The Lord of the Rings: The Two Towers", "Adventure", 2002, 94, List.of("Elijah Wood", "Ian McKellen")));
        service.addMovie(new Movie("The Lord of the Rings: The Return of the King", "Adventure", 2003, 94, List.of("Elijah Wood", "Viggo Mortensen")));
        service.addMovie(new Movie("The Godfather: Part II", "Crime", 1974, 13, List.of("Al Pacino", "Robert De Niro")));

        service.addUser("abc@gmail.com");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your email address to register or \"q\" to quit: ");
            String email = scanner.nextLine();
            if (email.equals("q")) {
                break;
            }
            String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            if (!patternMatches(email, regexPattern)) {
                System.out.println("Invalid email address. Please try again.");
                continue;
            }

            service.setCurrentUser(email);
            while (true) {
                System.out.println("Welcome, " + email + "!");
                System.out.println("Here are your options: " +
                        "\n1. Search Movie by Title." +
                        "\n2. Search Movie by Category." +
                        "\n3. Search Movie by single cast name." +
                        "\n4. Search Movie by multiple cast names." +
                        "\n5. Add a movie to favorites." +
                        "\n6. Remove a movie from favorites." +
                        "\n7. See your details." +
                        "\n8. Search your favorites by title." +
                        "\n9. Search your favorites by category." +
                        "\n10. Search your favorites by single cast name." +
                        "\n11. Search your favorites by multiple cast names." +
                        "\n12. Logout.");
                System.out.print("Please enter your choice: ");
                int choice = scanner.nextInt();
                System.out.println();
                if (choice == 1) {
                    service.searchByTitle(1);
                } else if (choice == 2) {
                    service.searchByCategory(1);
                } else if (choice == 3) {
                    service.searchByCast(1);
                } else if (choice == 4) {
                    service.searchByMultipleCastMembers(1);
                } else if (choice == 5) {
                    service.addToFavorites();
                } else if (choice == 6) {
                    service.removeFromFavorites();
                } else if (choice == 7) {
                    service.seeDetailsOfUser();
                } else if (choice == 8) {
                    service.searchByTitle(2);
                } else if (choice == 9) {
                    service.searchByCategory(2);
                } else if (choice == 10) {
                    service.searchByCast(2);
                } else if (choice == 11) {
                    service.searchByMultipleCastMembers(2);
                } else if (choice == 12) {
                    service.logout();
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
                Scanner temp_scanner = new Scanner(System.in);
                System.out.println("Please press c to continue or any key to logout.");
                String ok =  temp_scanner.nextLine();
                if (!ok.equals("c")) {
                    break;
                }
            }
        }

    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
