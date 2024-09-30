package test;

import product.Media;

public class TestMedia{
    public static void main(String[] args){
        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        int points = 0;

        Media media = new Media(title, url,points);
       
        String[] arr1 = {"https://youtube.com","file://media/lib/garp.mp4"};
        String[] arr2 = {"hello.world", "htt://badurl.com", "flub://badurl.com"};


        if(media.toString().startsWith(title) != true || media.toString().endsWith(" (" + url + ", " + points +" points)") != true){
            System.out.println("FAIL");
            System.out.println("Expected outcome:" + title + " (" + url + ")");
            System.out.println(media.toString());
        }

        for(String arr : arr1) {
            try {
                Media m = new Media("title", arr,points);
            } catch(Exception e) {
                System.err.println("FAIL: Unexpected exception for URL " + arr);
                System.err.println(e);
            }
        }
        
        for(String arr : arr2) {
            try {
                Media m = new Media("title", arr,points);
                System.err.println("FAIL: Missing exception for URL " + arr);
            } catch(Exception e) {
            }
        }
        
    }
}