/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.ArrayList;

/**
 *
 * @author nr
 */
public class Layer {
    
    private ArrayList<Side> sides = new ArrayList<>();

    @Override
    public String toString() {
          return "Layer{" + "sides=" + sides.toString() + '}';  
    }

    public ArrayList<Side> getSides() {
        return sides;
    }

    public void setSides(ArrayList<Side> sides) {
        this.sides = sides;
    }
    
    public void addSide(Side s ){
        sides.add(s);
    }

    
    

}