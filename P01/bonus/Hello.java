import java.util.Scanner;
public class Hello {
    public static void main(String[] args){
        String encoding = "UTF-8";
        Scanner in = new Scanner(System.in, encoding);
        System.out.print("What is your name? ");
        String output = in.nextLine();
        System.out.println("Hello " + output);
    }
    
}

