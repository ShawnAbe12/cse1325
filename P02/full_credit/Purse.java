// import java.util.Scanner;

import javax.swing.DebugGraphics;

public class Purse { 
      public static void main(String[] args) { 
      double totalSaved = 0;
      // Scanner scanner = new Scanner();
      Denomination myVar1 = Denomination.PENNY; 
      Denomination myVar2 = Denomination.NICKEL; 
      Denomination myVar3 = Denomination.DIME; 
      Denomination myVar4 = Denomination.QUARTER; 
      Denomination myVar5 = Denomination.QUARTER; 
      
      Coin[] coinArray = new Coin[5];

      coinArray[0] = new Coin(myVar5, 2011);
      coinArray[1] = new Coin(myVar1, 1908);
      coinArray[2] = new Coin(myVar2, 1928);
      coinArray[3] = new Coin(myVar3, 2004);
      coinArray[4]= new Coin(myVar4, 2030);

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

