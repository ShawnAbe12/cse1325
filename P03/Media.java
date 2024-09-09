import java.net.MalformedURLException;
import java.net.URL;

public class Media{
    private String title;
    private String url;

    public Media(String title, String url){
        this.title = title;
        this.url =url;
    }

    public boolean isValidURL(String url) {
        
        try {
            new URL(url); 
            return true; 
        } catch (MalformedURLException e) {
            throw new RuntimeException("NOT A VALID URL");
        }
    }

    @Override
    public String toString(){
        return "\""+title + " (" + url + ")\"";
    }
}