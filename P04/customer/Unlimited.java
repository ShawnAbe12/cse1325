package customer;

import product.Media;

class Unlimited extends Account{
    @Override
    public String play(Media media){
        return "Playing "  + media.toString();
    }
}