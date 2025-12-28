public  class Media {

    private String title;
    private String director;
    private int releaseYear;
    private String genre;
    private double rating;
    private boolean isWatched;

    public Media(String title,String director,int releaseYear){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }
    public Media(String title,String director,int releaseYear, String genre){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getTitle(){ return title; }
    public void setTitle(String title){this.title = title;}

    public String getDirector(){ return director; }
    public void setDirector(String director){this.director = director;}

    public int getReleaseYear(){ return releaseYear; }
    public void setReleaseYear(int releaseYear){this.releaseYear = releaseYear; }

    public String getGenre(){ return genre; }
    public void setGenre(String genre){this.genre = genre;}

    public double getRating(){ return rating; }
    public void setRating(double rating){
        if (rating >= 0 && rating <= 10) {
        this.rating = rating;
     }
    }

    public boolean getIsWatched(){ return isWatched; }
    public void setIsWatched(boolean isWatched){this.isWatched = isWatched;}

    public void markAsWatched(){
        isWatched = true;
    }

    public void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Genre: " + genre);
        if(isWatched){
            System.out.println("Watched");
        } else{
            System.out.println("Not Watched");
        }

    }
    public void displayInfo(boolean showRating){
        displayInfo();
        if(showRating){
            System.out.println("Rating: " + rating);
        }
    }

    public  String getMediaType() { return "Media"; }



}