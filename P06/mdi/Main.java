package mdi;

import moes.Moes;
import product.Media;
import customer.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    private static final String extension = ".txt";
    private static final String magicCookie = "saveFiles";
    private static final String fileVersion = "1.0";
    private String fileName;
    
    

    private Moes moes = new Moes();
    private String output;
    private Menu menu = new Menu();
    private boolean running;

    private void addStudent(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Student Name? ");
            String studentName = in.nextLine();
    
            System.out.println("Student ID? ");
            int studentID = Integer.parseInt(in.nextLine());
    
            // in.nextLine();
    
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
        }catch(Exception e){
            System.err.println("Could not add Student");
        }
        
    }

    private void newMoes(){
        moes = new Moes();
    }

    private void save(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write("" + magicCookie + "\n");
            bw.write("" + fileVersion + "\n" );
            moes.save(bw);

        }catch(Exception e){
            System.err.println("Could not save "+ e.getMessage());
            return;
        }
    } 
    private void saveAs(){
        System.out.println("The current file name is " + fileName+ "\n Please enter a new file name");
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        if(input == null){
            return;
        }

        if(!input.endsWith(extension)){
            input+=extension;
        }
        fileName = input;

        this.save();

    }

    private void open(){
        System.out.println("The current file name is " + fileName+ "\n Please enter a new file name");
        Scanner in = new Scanner(System.in);

        String newFileName = in.nextLine();
        if(newFileName == null){
            return;
        }
        if(!newFileName.endsWith(extension)){
            newFileName+=extension;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(newFileName))){
            if(magicCookie.equals(br.readLine()) && fileVersion.equals(br.readLine())){
                try{
                    Moes moes2 = new Moes(br);
                    moes = moes2;
                    fileName = newFileName;

                }catch(Exception e){
                    System.err.println("Could not create new Moes " + e.getMessage());
                }
            }
            else{
                throw new IOException("Incorrect magic Cookie or file Version");
            }
        }catch(Exception e){
            System.err.println("Can't be opened " + e.getMessage());
            return;
        }





    }

    private void listStudents(){
        output = moes.getStudentList();
    }


    private void addMedia(){
        try{
            Scanner in = new Scanner(System.in);

            System.out.println("Title? ");
            String mediaTitle = in.nextLine();
    
            System.out.println("URL? ");
            String mediaURL = in.nextLine();
    
            System.out.println("Points? ");
            int mediaPoints = Integer.parseInt(in.nextLine());
    
            moes.addMedia(new Media(mediaTitle, mediaURL, mediaPoints));
        }catch(Exception e){
            System.err.println("Could not add Media");
        }
        
        


    }
    private void playMedia(){
        Scanner in = new Scanner(System.in);

        System.out.println("Student Number? ");
        int studentNumber = in.nextInt();

        System.out.println("Media Number? ");
        int mediaNumber = in.nextInt();

        output = moes.playMedia(studentNumber, mediaNumber);


    
    } 
    private void listMedia(){
        output = moes.getMediaList();
    }


    private void listAvailablePoints(){
        Scanner in = new Scanner(System.in);

        System.out.println("Student Number? ");
        int studentNumber = in.nextInt();

        output = String.valueOf(moes.getPoints(studentNumber));

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
            output = "Not a Valid Purchase Ammount";
        }
        else{
            output = moes.buyPoints(studentNumber, pointsPurchased);
        }
    }

    public Main(){

        fileName = "test.txt";
        output = "";
        running = true;

        menu.addMenuItem(new MenuItem("Exit\n",                         () -> endApp()));

        menu.addMenuItem(new MenuItem("Play media",                     () -> playMedia()));
        menu.addMenuItem(new MenuItem("List media",                     () -> listMedia()));
        menu.addMenuItem(new MenuItem("List available points",          () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy points",                     () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add media\n",                    () -> addMedia()));

        menu.addMenuItem(new MenuItem("List all students",              () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add a student\n",                () ->addStudent()));
        
        menu.addMenuItem(new MenuItem("Discard Moes",                   () -> newMoes()));
        menu.addMenuItem(new MenuItem("Save Data",                    () -> save()));
        menu.addMenuItem(new MenuItem("Save Data as File Name",         () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open File\n",                    () -> open()));


        

    }
    private void mdi() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("File Name:  "+ fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if(magicCookie.equals(br.readLine()) && fileVersion.equals(br.readLine())){
            moes = new Moes(br);
        }
        
        br.close();
        while(running){
            System.out.println(menu.toString());
            if(!output.equals("")){
                System.out.println("--------------------------------\n");
                System.out.println(output + "\n");
                System.out.println("--------------------------------");
            }
            System.out.println("Selection: ");
            output = "";
            int selection = in.nextInt();
            if(selection >= 0 && selection <= 11){
                menu.run(selection);
            }
            else{
                System.out.println("Not a Valid Number");
            }
        }

    }
    private void endApp(){
        running = false;
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        main.mdi();
    }
    
}