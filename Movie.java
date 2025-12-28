public class Movie extends Media{

    public Movie(String title,String director,int releaseYear, String genre){
        super(title, director, releaseYear, genre);
    }

    @Override
    public String getMediaType(){
        return "Movie";
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Media type: " + getMediaType());;
    }
    @Override
    public void displayInfo(boolean showRating){
        super.displayInfo(showRating);
    }

}