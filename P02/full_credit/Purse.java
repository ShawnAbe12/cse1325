// import java.util.Scanner;

import javax.swing.DebugGraphics;

public class Purse { 
      public static void main(String[] args) { 
      double totalSaved = 0;
      // Scanner scanner = new Scanner();
      // Denomination myVar1 = Denomination.PENNY; 
      // Denomination myVar2 = Denomination.NICKEL; 
      // Denomination myVar3 = Denomination.DIME; 
      // Denomination myVar4 = Denomination.QUARTER; 
      // Denomination myVar5 = Denomination.QUARTER; 


      Denomination[] denominationsArray = {Denomination.PENNY,Denomination.NICKEL,Denomination.DIME,Denomination.QUARTER,Denomination.QUARTER};
      Coin[] coinArray = new Coin[5];
      int[] yearArray = {1908,1928,2004,2021,2011};

      int count = 0;
      for(Denomination denom : denominationsArray){
        coinArray[count] = new Coin(denom, yearArray[count]);
        count++;

      }
      

      // coinArray[0]= new Coin(myVar5, 2021);
      int minYear = coinArray[0].getYear();
      int maxYear = coinArray[0].getYear();
      for(Coin coin:coinArray){
        if(minYear > coin.getYear()){
          minYear = coin.getYear();
        }
        if(maxYear < coin.getYear()){
          maxYear = coin.getYear();
        }

        totalSaved += coin.getValue();
      }
      System.out.println("You have $ "+totalSaved + " in coins between " + minYear +" and "+ maxYear);
      
    } 
  }

