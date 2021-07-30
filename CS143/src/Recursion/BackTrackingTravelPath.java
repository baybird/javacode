package Recursion;

/**
 *
 * @author robert
 */
public class BackTrackingTravelPath {
    
    public static void main(String[] args) {
        BackTrackingTravelPath bt = new BackTrackingTravelPath();
        bt.travel(1, 2);
    }
    
    public void travel(int x, int y){
        System.out.println(travel(x, y, ""));
    }
    
    public String travel(int x, int y, String path){
        
        if(x == 0 && y==0){
            return path + "\n";
        }
        
        if(x == 0 && y==1){
            return path + "N\n";
        }
        
        if(x == 1 && y==0){
            return path + "E\n";
        }
        
        String output = new String();
        if(x>0){
            output += travel(x-1, y, path+"E ");
            
        }
        
        if(y>0){
            output += travel(x, y-1, path+"N ");
        }
        
        if(x>0 && y>0){
            output += travel(x-1, y-1, path+"NE ");
        }
        
        return output;
    }
}
