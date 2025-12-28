public class Documentary extends Media{

    private String topic;
    private boolean isEducational;

    public Documentary(String title,String director,int releaseYear, String topic, boolean isEducational){
        super(title, director, releaseYear);
        this.topic = topic;
        this.isEducational = isEducational;
    }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    @Override
    public String getMediaType(){
        return "Documentary";
    }
    public String getEducationalValue() {
    return isEducational ? "Educational Documentary" : "Not Educational";
}

}