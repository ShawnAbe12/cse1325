// import java.util.Scanner;
public class Purse { 
      public static void main(String[] args) { 
      double totalSaved = 0;
      // Scanner scanner = new Scanner();

      Denomination[] denominationsArray = {Denomination.PENNY,Denomination.NICKEL,Denomination.DIME,Denomination.QUARTER,Denomination.QUARTER};
      Coin[] coinArray = new Coin[5];
      int[] yearArray = {1908,1928,2004,2021,2011};

      int count = 0;
      for(Denomination denom : denominationsArray){
        coinArray[count] = new Coin(denom, yearArray[count]);
        count++;
      }

      int minYear = coinArray[0].getYear();
      int maxYear = coinArray[0].getYear();
      for(Coin coin:coinArray){
        System.out.println(coin.toString() + " " + coin.getWeight());
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

