public class Episode {

    private String title;
    private int duration; 
    private int episodeNumber;
    private int seasonNumber;

    public Episode(String title,int duration,int episodeNumber,int seasonNumber){
        this.title = title;
        this.duration = duration;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    public String geTitle(){ return title;}
    public void setTitle(String title ){this.title =title ;}
    
    public int getDuration(){ return duration;}
    public void setDuration(int duration){this.duration =duration ;}

    public int getEpisodeNumber(){ return episodeNumber;}
    public void setEpisodeNumber(int episodeNumber){this.episodeNumber = episodeNumber;}

    public int getSeasonNumber(){ return seasonNumber;}
    public void setSeasonNumber(int seasonNumber){this.seasonNumber = seasonNumber;}

    public void displayEpisodeInfo(){
        System.out.println("Episode title: " + title);
        System.out.println("Duration: " + duration + "minutes");
        System.out.println("Episode Number: " + episodeNumber);
        System.out.println("Season: " + seasonNumber);
    }
}