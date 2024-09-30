package mdi;

import moes.Moes;
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


    // private void addMedia(){
    //     continue;
    // }
    // private void playMedia(){
    //     continue;
    // } 
    // private void listMedia(){
    //     continue;
    // }


    // private void listAvailablePoints(){
    //     continue;
    // }
    // private void buyPoints(){
    //     continue;
    // }

    public static void main(String[] args){
        System.out.println("Hello World");
    }
}