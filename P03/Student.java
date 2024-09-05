public class Student{
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name,int id,String email){
        this.name = name;
        this.id = id; 
        this.email = email;
    }
    public String requestMedia(Media media){
        return media.toString();
    }

    @Override
    public String toString(){
        return "";
    }
}