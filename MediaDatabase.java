import java.util.List;
import java.util.ArrayList;

public class MediaDatabase {

    private List<Media> mediaList;

    public MediaDatabase() {
        mediaList = new ArrayList<>();
    }

    // Add methods
    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public void addMedia(String title, String director, int year) {
        Media media = new Media(title, director, year);
        mediaList.add(media);
    }

    // Search methods
    public Media searchByTitle(String title) {
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void searchByDirector(String director) {
        for (Media media : mediaList) {
            if (media.getDirector().equalsIgnoreCase(director)) {
                media.displayInfo();
            }
        }
    }

    public void searchByGenre(String genre) {
        for (Media media : mediaList) {
            if (media.getGenre().equalsIgnoreCase(genre)) {
                media.displayInfo();
            }
        }
    }

    // Management methods
    public void markAsWatched(String title) {
        Media media = searchByTitle(title);
        if (media != null) {
            media.markAsWatched();
        }
    }

    public void rateMedia(String title, double rating) {
        Media media = searchByTitle(title);
        if (media != null) {
            media.setRating(rating);
        }
    }

    public void displayUnwatchedMedia() {
        for (Media media : mediaList) {
            if (!media.getIsWatched()) {
                media.displayInfo();
            }
        }
    }

    public void displayWatchedMedia() {
        for (Media media : mediaList) {
            if (media.getIsWatched()) {
                media.displayInfo();
            }
        }
    }

    public void displayAllMedia() {
        for (Media media : mediaList) {
            media.displayInfo();
        }
    }

    // Statistics
    public double getAverageRating() {
        if (mediaList.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Media media : mediaList) {
            sum += media.getRating();
        }
        return sum / mediaList.size();
    }

    public int getMediaCount() {
        return mediaList.size();
    }

    public List<Media> getMediaByType(String type) {
        List<Media> result = new ArrayList<>();

        for (Media media : mediaList) {
            if (media.getMediaType().equalsIgnoreCase(type)) {
                result.add(media);
            }
        }
        return result;
    }
}
