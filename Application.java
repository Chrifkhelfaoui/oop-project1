import java.util.Scanner;

public class Application {

    private MediaDatabase database;
    private Scanner scanner;
    private boolean isRunning;

    public Application() {
        database = new MediaDatabase();
        scanner = new Scanner(System.in);
        isRunning = true;
    }

    public void start() {
        while (isRunning) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addMedia();
                    break;
                case 2:
                    searchMedia();
                    break;
                case 3:
                    markAsWatched();
                    break;
                case 4:
                    rateMedia();
                    break;
                case 5:
                    viewStatistics();
                    break;
                case 6:
                    database.displayAllMedia();
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n Media database menu");
        System.out.println("1. Add Media");
        System.out.println("2. Search Media");
        System.out.println("3. Mark as Watched");
        System.out.println("4. Rate Media");
        System.out.println("5. View Statistics");
        System.out.println("6. Display All Media");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void addMedia() {
        System.out.println("\n1. Movie");
        System.out.println("2. Documentary");
        System.out.println("3. TV Series");
        System.out.print("Choose media type: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Release Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Genre: ");
                String genre = scanner.nextLine();
                database.addMedia(new Movie(title, director, year, genre));
                break;

            case 2:
                System.out.print("Topic: ");
                String topic = scanner.nextLine();
                System.out.print("Is Educational (true/false): ");
                boolean educational = scanner.nextBoolean();
                database.addMedia(new Documentary(title, director, year, topic, educational));
                break;

            case 3:
                System.out.print("Genre: ");
                String serieGenre = scanner.nextLine();
                System.out.print("Number of seasons: ");
                int seasons = scanner.nextInt();
                database.addMedia(new Series(title, director, year, serieGenre, null, seasons));
                break;

            default:
                System.out.println("Invalid media type.");
                return;
        }

        System.out.println("Media added successfully!");
    }

    private void searchMedia() {
        System.out.println("\nSearch by:");
        System.out.println("1. Title");
        System.out.println("2. Director");
        System.out.println("3. Genre");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter search value: ");
        String value = scanner.nextLine();

        switch (choice) {
            case 1:
                Media media = database.searchByTitle(value);
                if (media != null) {
                    media.displayInfo(true);
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 2:
                database.searchByDirector(value);
                break;
            case 3:
                database.searchByGenre(value);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void markAsWatched() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        database.markAsWatched(title);
        System.out.println("Media marked as watched (if found).");
    }

    private void rateMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        System.out.print("Enter rating (0-10): ");
        double rating = scanner.nextDouble();
        database.rateMedia(title, rating);
        System.out.println("Rating saved (if media exists).");
    }

    private void viewStatistics() {
        System.out.println("\n--- Statistics ---");
        System.out.println("Total media: " + database.getMediaCount());
        System.out.println("Average rating: " + database.getAverageRating());

        System.out.println("\nWatched media:");
        database.displayWatchedMedia();

        System.out.println("\nUnwatched media:");
        database.displayUnwatchedMedia();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
