package mdi;

import moes.Moes;
import product.Media;
import customer.Student;

import java.util.Scanner;

public class Main{
    private Moes moes = new Moes();
    private String output;
    private Menu menu = new Menu();
    private boolean running;

    private void addStudent(){
        Scanner in = new Scanner(System.in);
        System.out.println("Student Name? ");
        String studentName = in.nextLine();

        System.out.println("Student ID? ");
        int studentID = in.nextInt();

        System.out.println("Student email? ");
        String studentEmail = in.nextLine();

        System.out.println("(a)lacarte or (u)nlimited? ");
        String studentType = in.nextLine();
        boolean type = false;

        switch(studentType){
            case("a"):
                type = false;
                break;
            case("u"):
                type = true;
                break;
        }
        Student student = new Student(studentName,studentID,studentEmail,type);
        moes.addStudent(student);
    }
    private void listStudents(){
        System.out.println(moes.getStudentList());
    }


    private void addMedia(){
        Scanner in = new Scanner(System.in);

        System.out.println("Title? ");
        String mediaTitle = in.nextLine();

        System.out.println("URL? ");
        String mediaURL = in.nextLine();

        System.out.println("Points? ");
        int mediaPoints = in.nextInt();

        moes.addMedia(new Media(mediaTitle, mediaURL, mediaPoints));


    }
    private void playMedia(){
        Scanner in = new Scanner(System.in);

        System.out.println("Student Number? ");
        int studentNumber = in.nextInt();

        System.out.println("Media Number? ");
        int mediaNumber = in.nextInt();

        System.out.println(moes.playMedia(studentNumber, mediaNumber));


    
    } 
    private void listMedia(){
        System.out.println(moes.getMediaList());
    }


    private void listAvailablePoints(){
        Scanner in = new Scanner(System.in);

        System.out.println("Student Number? ");
        int studentNumber = in.nextInt();

        System.out.println(moes.getPoints(studentNumber));

    }
    private void buyPoints(){
    //         Method buyPoints() will collect a student index from the user, get their current points total, then ask the
    //         user how many additional points to buy. Perform data validation on the result - no purchasing negative points!
    //         Otherwise, use Moes' buyPoints method to buy the points, printing the result

        Scanner in = new Scanner(System.in);

        System.out.println("Student Number? ");
        int studentNumber = in.nextInt();
        moes.getPoints(studentNumber);

        System.out.println("How many points would you like to purchase?");
        int pointsPurchased = in.nextInt();

        if(pointsPurchased < 0){
            System.out.println("Not a Valid Purchase Ammount");
        }
        else{
            System.out.printn(moes.buyPoints(studentNumber, pointsPurchased));
        }
    }

    public static void main(String[] args){
        System.out.println("Hello World");
    }
}