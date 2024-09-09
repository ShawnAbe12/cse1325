public class TestMedia{
    public static void main(String[] args){
        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        Media media = new Media(title, url);
       
        String[] arr1 = {"https://youtube.com","file://media/lib/garp.mp4"};
        String[] arr2 = {"hello.world", "htt://badurl.com", "flub://badurl.com"};

        // media.isValidURL(arr1[0]);

        if(media.toString().startsWith("\""+title) != true || media.toString().endsWith("("+url+")\"") != true){
            System.out.println("FAIL");
            System.out.println("Expected outcome:\n\""+ title + " (" + url + ")\"");
            System.out.println(media.toString());
        }

        //Valid array checking
        for(int i =0; i< arr1.length; i++){
            media.isValidURL(arr1[i]);
        }

        //Invalid array checking 
        for(int i =0; i< arr2.length; i++){
            media.isValidURL(arr2[i]);
        }
        
    }
}