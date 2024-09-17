package customer;

import product.Media;

class Alacarte extends Account{
    private int pointsRemaining;
    public void buyPoints(int points){
        System.out.println("here");
    }
    public int getPointsRemaining(){
        return pointsRemaining;
    }
    @Override
    public String play(Media media){
        int required = media.getPoint() - pointsRemaining;
        if(media.getPoint() > pointsRemaining){
            return "Buy more points: Requires: " + required + "Points \nYou currently have: " + pointsRemaining +" Points\n";
        }
        else{
            return "Playing " + media.toString();
        }
        
    }
}