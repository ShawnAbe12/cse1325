public class Coin {
    
    private Denomination denomination;
    private int year;
    public Coin(Denomination denomination, int year){
        this.denomination = denomination;
        this.year = year;
    }

    public double getValue(){
        return denomination.getValue();
    }
    public int getYear(){
        return year;
    }
    
    public double getWeight(){
        if(this.denomination.toString().equals("penny")){
            if(year <= 1983){
                return 3.110;
            }
            else if (year >=1984){
                return 2.500;
            }
        }
        else if(this.denomination.toString().equals("nickel")){
            return 5.000;
        }
        else if(this.denomination.toString().equals("dime")){
            if(year <= 1965){
                return 2.500;
            }
            else if(year >= 1966){
                return 2.268;
            }
        }
        else if(this.denomination.toString().equals("quarter")){
            if(year <= 1965){
                return 6.250;
            }
            else if(year >= 1966){
                return 5.670;
            }

        }
        return 0;
        
    }

    @Override
    public String toString(){
        return "" + this.getYear() + "  " + this.denomination.toString(); 
    }
    
}
