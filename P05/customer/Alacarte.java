package customer;

import product.Media;

public class Alacarte extends Account{
    private int pointsRemaining;
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