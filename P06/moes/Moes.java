package moes;

import product.Media;
import customer.Student;

import customer.Unlimited;
import customer.Alacarte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Moes{
    
   
    // private ArrayList<String> elements = new ArrayList<String>();

    private ArrayList<Media> library = new ArrayList<Media>();
    private ArrayList<Student> customers = new ArrayList<Student>();
    private int sizeOfLibrary;
    private int sizeOfCustomers;

    public Moes(){
        this.sizeOfLibrary = 0;
        this.sizeOfCustomers = 0;
    }
    public Moes(BufferedReader br) throws IOException{
        sizeOfLibrary = Integer.parseInt(br.readLine());
        for(int i =0; i< sizeOfLibrary; i++){
            library.add(new Media(br));
        }

        sizeOfCustomers = Integer.parseInt(br.readLine());
        for(int i =0; i< sizeOfCustomers; i++){
            customers.add(new Student(br));
        }
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + sizeOfLibrary + "\n");
        for(Media i: library){
            i.save(bw);
        }

        bw.write("" + sizeOfCustomers + "\n");
        for(Student i: customers){
            i.save(bw);
        }
    }

    public void addMedia(Media media){
        library.add(media);
        sizeOfLibrary++;
    }

    public String getMediaList(){
        int count = 0;
        String finalString = "";
        for(Media lib: library){
            finalString += "" + count + ") " + lib.toString() + "\n";
            count++;
        }
        return finalString;
    }

    public void addStudent(Student student){
        customers.add(student);
        sizeOfCustomers++;
    }

    public String getStudentList(){
        int count = 0;
        String finalString = "";
        for(Student cust: customers){
            finalString += "" + count + ") " + cust.toString() + "\n";
            count++;
        }
        return finalString;

    }

    public int getPoints(int studentIndex){
        Student stu = customers.get(studentIndex);
        if(stu.getAccount() instanceof Alacarte){
            Alacarte ala = (Alacarte)stu.getAccount();
            return ala.getPointsRemaining();
        }
        else if(stu.getAccount() instanceof Unlimited){
            return Integer.MAX_VALUE;
        }
        else{
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    public String buyPoints(int studentIndex, int points){
        Student stu = customers.get(studentIndex);
        if(stu.getAccount() instanceof Alacarte){
            Alacarte ala = (Alacarte)stu.getAccount();
            ala.buyPoints(points);
            return "Student now has: "+ ala.getPointsRemaining() + " Points";
        }
        else if(stu.getAccount() instanceof Unlimited){
            return "Student has type Unlimited and as such does not require additional points";
        }
        else{
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }


    }
    public String playMedia(int studentIndex,int mediaIndex){
        Student stu = customers.get(studentIndex);
        Media med = library.get(mediaIndex);

        return stu.requestMedia(med);

    }





}