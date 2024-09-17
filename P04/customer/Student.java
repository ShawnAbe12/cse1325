package customer;

import customer.Unlimited;
import customer.Alacarte;

import product.Media;

public class Student{
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name,int id,String email, Boolean unlimited){

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