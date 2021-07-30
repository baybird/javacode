/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparable;

/**
 *
 * @author robert
 */
public class WaterBottle {
    private double water;
    
    public WaterBottle(double waterWeight){
        water = waterWeight;
    }
    
    public double getContents(){
        return water;
    }
   
   
public int compareTo(WaterBottle other){
    

    // A water bottle is considered "less" than another water bottle if it 
    // currently contains a smaller amount of water inside than the other
    // water bottle. 
    if(getContents() < other.getContents()){
        return -1;
    }

    // It is considered "more" than another water bottle if it currently 
    // contains more water inside than the other water bottle. 
    if(getContents() > other.getContents()){
        return 1;
    }

    // They are considered "equal" if they contain the exact same amount of 
    // water inside.
    return 0;
}
}
