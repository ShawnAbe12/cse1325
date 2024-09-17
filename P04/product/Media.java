package product;

public class Media {
    private String title;
    private String url;
    private int points;


    public Media(String title, String url,int points) {
        this.title = title;
        this.url = url;
        this.points = points;

        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
        }
        
    }
    @Override
    public String toString() {
        return title + " (" + url + ") Points Remaining: " + points;
    }
}