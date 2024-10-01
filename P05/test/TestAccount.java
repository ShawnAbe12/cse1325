package test;

import customer.Unlimited;

public class TestAccount{
    public static void main(String[] args){
        Unlimited acc1 = new Unlimited();
        Unlimited acc2 = new Unlimited();
        if(acc1.getAccountNumber() !=1 || acc2.getAccountNumber() !=2)
        {
            System.out.println("FAIL");
            System.out.println("Expected outcome:\nAccount number 1: 1\nAccount number 2: 2\n"+ "Actual outcome:\nAccount number 1: " +acc1.getAccountNumber() + "\nAccount number 2: " + acc2.getAccountNumber());
            System.exit(-1);
        }
    }
}