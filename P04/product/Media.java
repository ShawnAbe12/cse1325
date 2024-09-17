package product;

public class Media {
    public Media(String title, String url) {
        this.title = title;
        this.url = url;

        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
        }
        
    }
    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
    private String title;
    private String url;
}