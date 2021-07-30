
package interfaces;

/**
 *
 * @author robert
 */
public class RectangularShape implements Shape{
    
    double length, width;
    
    public RectangularShape(double l, double w){
        length = l;
        width = w;
    
    }
    
    @Override
    public String toString(){
        return null;
    }

    @Override
    public String getDescription() {
        
        return "this is a rectangle";
    }

    @Override
    public double calcArea() {
        return (length * width);
    }
    
}
