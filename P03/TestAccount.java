public class TestAccount{
    public static void main(String[] args){
        Account acc = new Account();
        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        Media media = new Media(title, url);
        System.out.println(acc.play(media));
    }
}