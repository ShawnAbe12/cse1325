public class TestMedia{
    public static void main(String[] args){
        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        Media media = new Media(title, url);
       
        System.out.println(media.isValidURL(url));
        //Check to see if the media to string starts with title and ends with url enclosed inside ()
        if(media.toString().startsWith("\""+title) != true || media.toString().endsWith("("+url+")\"") != true){
            System.out.println("FAIL");
            System.out.println("Expected outcome:\n\""+ title + " (" + url + ")\"");
            System.out.println(media.toString());
            System.exit(-1);
        }
    }
}