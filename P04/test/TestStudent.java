package test;

// import customer.Account;
import customer.Student;
import product.Media;

import java.beans.Expression;

public class TestStudent{
    public static void main(String[] args){
        String name = "Shawn";
        int id = 10090564;
        String email = "sxa0449@mavs.uta.edu";
        boolean unlimited = true;
        int numOfFails = 0;

        
        String correctExpression = "\"Non-UTA email address: "+ email + "23";

        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        int points = 0;
        
        Media media = new Media(title, url,points);

        String correctMediaString = "Playing " + media.toString();
        
        Student stu = new Student(name, id, email,unlimited);
        
        
        // Student stu = new Student(name, id, email);
        try {
            Student stu1 = new Student(name, id, email + "23",unlimited);
        } 
        catch (Exception e) {
            if(!e.getMessage().equals(correctExpression)){
                numOfFails++;
                System.out.println("FAIL");
                System.out.println("Expected Outcome: \n"+correctExpression +"\n" + "Actual Outcome: \n" +e.getMessage());
            }
        }

        String correctString = "\""+name + " ("+id+","+email+",Account Number #1)\"";

        if(stu.toString().equals(correctString) != true){
            System.out.println("FAIL");
            System.out.println("Expected Outcome: \n"+correctString +"\n" + "Actual Outcome: \n" +stu.toString());
            numOfFails++;
        }

        if(stu.requestMedia(media).equals(correctMediaString) != true){
            System.out.println("FAIL");
            System.out.println("Expected Outcome: \n"+correctMediaString +"\n" + "Actual Outcome: \n" +stu.requestMedia(media));
            numOfFails++;
        }
        if(numOfFails > 0){
            System.exit(numOfFails);
        }
        else{
            System.exit(0);
        }
        // System.out.println(numOfFails);
    }
}

        
        