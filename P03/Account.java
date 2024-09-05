public class Account {
    private int accountNumber;
    private int nextAccountNumber;
    
    public Account(){
        this.accountNumber = 0;
        this.nextAccountNumber = 0;

    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public String play(Media media){
        return media.toString();
    }
    
    
}