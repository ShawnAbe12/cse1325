/**
 * Access a variety of Videos, Music, and Podcast Legally!!
 * 
 * @author Shawn Abraham
 * @version 1.0
 * @since 1.0
 * 
 */
package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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

    public Media(BufferedReader br) throws IOException{
        String s;

        s = br.readLine();
        this.title = s;

        s = br.readLine();
        this.url = s;

        int point= Integer.parseInt(br.readLine());
        this.points = point;
    }

    public void save(BufferedWriter bw)throws IOException{
        bw.write("" + title + "\n");
        bw.write("" + url + "\n");
        bw.write("" + points + "\n");
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
        return title + " (" + url + ", " + points +" points)";
    }
}