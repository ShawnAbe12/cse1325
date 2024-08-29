public class Coin {
    
    Denomination denomination;
    int year;
    public Coin(Denomination denomination, int year){
        this.denomination = denomination;
        this.year = year;
    }

    public double getValue(){
        switch(denomination){
            case "PENNY":
            return 0.01;
            case "NICKEL":
            return 0.05;
            case "DIME":
            return 0.10;
            case "QUARTER":
            return 0.25;
        }
        return 0;
    }
    
}
