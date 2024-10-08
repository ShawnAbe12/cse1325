package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public class Alacarte extends Account{
    private int pointsRemaining;
    
    public Alacarte(){
        super();
    }
    public Alacarte(BufferedReader br)throws IOException{
        super(br);
        pointsRemaining = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException{
        super.save(bw);
        bw.write("" + pointsRemaining +"\n");
    }

    
    public void buyPoints(int points){
        pointsRemaining +=points;
    }
    public int getPointsRemaining(){
        return pointsRemaining;
    }
    @Override
    public String play(Media media){
        int required = media.getPoint() - pointsRemaining;
        if(media.getPoint() > pointsRemaining){
            return "Buy more points: Requires: " + required + " Points \nYou currently have: " + pointsRemaining +" Points\n";
        }
        else{
            pointsRemaining -= media.getPoint();
            return "Playing " + media.toString();
        }
        
    }
}