package customer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public abstract class Account {
    private int accountNumber;
    private static int nextAccountNumber = 1;
    
    public Account(){
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;

    }
    
    public Account(BufferedReader br) throws IOException{
        String s;
        this.accountNumber = Integer.parseInt(br.readLine());
        nextAccountNumber = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + accountNumber + "\n");
        bw.write("" + nextAccountNumber +"\n");
        bw.write("\n");
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public abstract String play(Media media);
    
    
}