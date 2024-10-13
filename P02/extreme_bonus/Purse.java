// import java.util.Scanner;
import java.lang.Math;
public class Purse { 
      public static void main(String[] args) { 
      double totalSaved = 0;
      double weightGrams = 0;
      // Scanner scanner = new Scanner();
      System.out.println("" +Denomination.PENNY);

      Denomination[] denominationsArray = {Denomination.PENNY,Denomination.NICKEL,Denomination.DIME,Denomination.QUARTER,Denomination.PENNY};
      Coin[] coinArray = new Coin[5];
      int[] yearArray = {1909,1939,1946,1964,2014};

      int count = 0;
      for(Denomination denom : denominationsArray){
        coinArray[count] = new Coin(denom, yearArray[count]);
        count++;
      }

      int minYear = coinArray[0].getYear();
      int maxYear = coinArray[0].getYear();
      for(Coin coin:coinArray){
        System.out.println(coin.toString());
        if(minYear > coin.getYear()){
          minYear = coin.getYear();
        }
        if(maxYear < coin.getYear()){
          maxYear = coin.getYear();
        }
        weightGrams += coin.getWeight();
        totalSaved += coin.getValue();
      }

      String weight = String.format("%.3f", weightGrams);
      String saved = String.format("%.2f", totalSaved);

      System.out.println("You have $ "+saved + " in coins between " + minYear +" and "+ maxYear + " weighing " + weight + " grams");
      
    } 
  }

