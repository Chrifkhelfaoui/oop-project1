import java.util.List;
import java.util.ArrayList;

public class Series extends Media{

    private int nbOfSeasons;
    private List<Episode> episodes;

    public Series(String title,String director,int releaseYear, String genre,List<Episode> episodes, int nbOfSeasons){
        super(title, director, releaseYear, genre);
        this.episodes = (episodes != null) ? episodes : new ArrayList<>();
        this.nbOfSeasons = nbOfSeasons;
    }

    @Override
    public String getMediaType(){
        return "TV Series";
    }

    public int getTotalEpisodes(){
        return episodes.size();
    }

    public void displaySeriesInfo(){
        super.displayInfo();
        System.out.println("Number of Seasons: " + nbOfSeasons);
    }
    public void displaySeriesInfo(boolean showTotalEpisodes){
        if(showTotalEpisodes){
            displaySeriesInfo();
            System.out.println("Total number of episodes: " + getTotalEpisodes());
        }
    } 
}