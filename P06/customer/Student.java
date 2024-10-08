package customer;

import customer.Unlimited;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import customer.Alacarte;

import product.Media;

public class Student{
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name,int id,String email, Boolean unlimited)throws IOException{

        if(email.endsWith("@uta.edu") != true && email.endsWith("mavs.uta.edu") != true ){
            throw new IllegalArgumentException("\"Non-UTA email address: "+ email);
        }
        
        this.name = name;
        this.id = id; 
        this.email = email;
        if(unlimited){
            this.account = new Unlimited();
        }
        else{
            this.account = new Alacarte();
        }
    }

    public Student(BufferedReader br)throws IOException{
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();
        if(br.readLine().equals("Unlimited")){
            this.account = new Unlimited(br);
        }
        else{
            this.account = new Alacarte(br);
        }
    }

    public void save(BufferedWriter bw)throws IOException{
        bw.write(""+ name + "\n");
        bw.write(""+ id + "\n");
        bw.write(""+ email + "\n");
        bw.write(""+ account.getClass().getName() + "\n");

    }

    public String requestMedia(Media media){
        return account.play(media);
    }
    public Account getAccount(){
        return account;
    }

    @Override
    public String toString(){
        return "\""+name + " ("+id+","+email+",Account Number #"+account.getAccountNumber()+")\"";
    }
}