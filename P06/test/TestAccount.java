package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import customer.Alacarte;
import customer.Unlimited;

public class TestAccount{
    private static String fileName = "C:\\Users\\johna\\cse1325\\P06\\saveFiles\\account.txt"; 
    public static void main(String[] args) throws IOException{
        Unlimited acc1 = new Unlimited();
        Alacarte acc2 = new Alacarte();
        // Unlimited acc2 = new Unlimited();
        // Unlimited acc3 = new Unlimited();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        acc1.save(bw);
        acc2.save(bw);
        // acc2.save(bw);
        // acc3.save(bw);
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String s;
        while((s = br.readLine())!= null){
            System.out.println(s);
        }
        br.close();
        // if(acc1.getAccountNumber() !=1 || acc2.getAccountNumber() !=2)
        // {
        //     System.out.println("FAIL");
        //     System.out.println("Expected outcome:\nAccount number 1: 1\nAccount number 2: 2\n"+ "Actual outcome:\nAccount number 1: " +acc1.getAccountNumber() + "\nAccount number 2: " + acc2.getAccountNumber());
        //     System.exit(-1);
        // }
    }
}