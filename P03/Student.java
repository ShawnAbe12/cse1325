public class Student{
    private String name;
    private int id;
    private String email;
    private Account account = new Account();

    public Student(String name,int id,String email){
        try {
            if(email.endsWith("@uta.edu") != true && email.endsWith("mavs.uta.edu") != true ){
                throw new IllegalArgumentException("\"Non-UTA email address: "+ email);
            }
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);    
        }
        
        this.name = name;
        this.id = id; 
        this.email = email;
    }
    public String requestMedia(Media media){
        return account.play(media);
    }

    @Override
    public String toString(){
        return "\""+name + " ("+id+","+email+",Account Number #"+account.getAccountNumber()+")\"";
    }
}