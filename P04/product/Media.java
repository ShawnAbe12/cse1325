/**
 * Access a variety of Videos, Music, and Podcast Legally!!
 * 
 * @author Shawn Abraham
 * @version 1.0
 * @since 1.0
 * 
 */
package product;

public class Media {
    private String title;
    private String url;
    private int points;

    /**
     * Creates a Media Isntance
     *
     * @param title
     * @param url
     * @param points
     * 
     * @since 1.0
     */
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
    /**
     * Returns the number of points a Media cost
     * 
     * @return number of points
     * 
     * @since 1.0
     */
    public int getPoint(){
        return points;
    }

    /**
     * Prints Media's base output
     * 
     * @return title of media, url of media, and points of media
     * 
     * @since 1.0 
     */
    @Override
    public String toString() {
        return title + " (" + url + ") Points Remaining: " + points;
    }
}