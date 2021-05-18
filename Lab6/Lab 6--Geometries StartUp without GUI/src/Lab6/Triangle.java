package Lab6;

import java.awt.Point;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Triangle.java
 * Project      Lab6
 * Description  This class provides computation methods for computing a triangle's
 *              area, perimeter, and angles.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/15/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Triangle {
    // declaration of vars and constants
    private double x1, y1, x2, y2, x3, y3;
    private Point[] points = {null, null, null};
    final int MAX_SPACES = 20;
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Triangle()
     * Description      Default constractor
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Triangle() {
        this(0, 0, 0, 0, 0, 0);
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Triangle()
     * Description      Overloaded constractor
     * @param x1-double
     * @param y1-double
     * @param x2-double
     * @param y2-double
     * @param x3-double
     * @param y3 -double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           distance()
     * Description      This method computes the distance between two given vertices.
     * @param x1-double
     * @param y1-double
     * @param x2-double
     * @param y2-double
     * @return double 
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getArea()
     * Description      This method computes the area of a triangle with Heron's formula.
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getArea() {
        double sideA, sideB, sideC, semiPerimeter;

        sideA = this.distance(x1, y1, x2, y2);
        sideB = this.distance(x1, y1, x3, y3);
        sideC = this.distance(x2, y2, x3, y3);
        semiPerimeter = (sideA + sideB + sideC)/2;

        // Heron's formula
        // A = sqrt(s(s-a)(s-b)(s-c))
        return Math.sqrt(
                semiPerimeter
                * (semiPerimeter - sideA)
                * (semiPerimeter - sideB)
                * (semiPerimeter - sideC)
        );
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getArea()
     * Description      Overloaded method to computes the area of a triangle with determinants.
     * @param x1-double
     * @param y1-double
     * @param x2-double
     * @param y2-double
     * @param x3-double
     * @param y3-double
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // triangle area using determinants
        double area = Math.abs(
            ((x1 * y2 - y1 * x2) + (x2 * y3 - y2 * x3) + (x3 * y1 - y3 * x1))/2.0
        );
        
        return area;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getPerimeter()
     * Description      This method computes the perimeter of a triangle.
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getPerimeter() {
        double sideA, sideB, sideC;
        sideA = this.distance(x1, y1, x2, y2);
        sideB = this.distance(x1, y1, x3, y3);
        sideC = this.distance(x2, y2, x3, y3);

        return (sideA + sideB + sideC);
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getPerimeter()
     * Description      Overloaded method computes the perimeter by adds up the given sides.
     * @param sideA-double
     * @param sideB-double
     * @param sideC-double
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getPerimeter(double sideA, double sideB, double sideC) {
        return (sideA + sideB + sideC);
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAngleC()
     * Description      This method computes the angle C.
     * @param sideA-double
     * @param sideB-double
     * @param sideC-double
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getAngleC(double sideA, double sideB, double sideC) {
        // Law of cos
        return Math.cos((sideA * sideA + sideB * sideB - sideC * sideC)/(2 * sideA * sideB));
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAngleB()
     * Description      This method computes the angle B.
     * @param sideA-double
     * @param sideB-double
     * @param sideC-double
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getAngleB(double sideA, double sideB, double sideC) {
        // Law of cos
        return Math.cos((sideB * sideB + sideC * sideC - sideA * sideA)/(2 * sideB * sideC));
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAngleA()
     * Description      This method computes the angle A.
     * @param sideA-double
     * @param sideB-double
     * @param sideC-double
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getAngleA(double sideA, double sideB, double sideC) {
        return Math.PI - (getAngleB(sideA, sideB, sideC) + getAngleC(sideA, sideB, sideC));
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           padSpaces()
     * Description      Adds blank spaces between two strings.
     * @author          <i>Robert Tang</i>
     * @param first-String
     * @param second-String
     * @return line-String
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String padSpaces(String first, String second) {
        StringBuilder line = new StringBuilder(first);

        //find number of spaces needed to pad the string for right-justification
        int numSpaces = MAX_SPACES - first.trim().length() - second.trim().length();

        for (int i = 0; i < numSpaces; i++) {
            line.append(" ");	//add appropriate number of spaces
        }
        line.append(second.trim()).append('\n');	//add second string
        
        return line.toString();
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getX1()
     * Description      This method gets the value of x1.
     * @author          <i>Robert Tang</i>
     * @return double
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getX1() {
        return x1;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setX1()
     * Description      This method sets the value of x1.
     * @param x1-double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getY1()
     * Description      This method gets the value of y1.
     * @author          <i>Robert Tang</i>
     * @return double
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getY1() {
        return y1;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setY1()
     * Description      This method sets the value of y1.
     * @param y1-double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getX2()
     * Description      This method gets the value of x2.
     * @author          <i>Robert Tang</i>
     * @return double
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getX2() {
        return x2;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setX2()
     * Description      This method sets the value of x2.
     * @param x2-double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getY2()
     * Description      This method gets the value of y2.
     * @author          <i>Robert Tang</i>
     * @return double
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getY2() {
        return y2;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setY2()
     * Description      This method sets the value of y2.
     * @param y2-double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getX3()
     * Description      This method gets the value of x3.
     * @author          <i>Robert Tang</i>
     * @return double
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getX3() {
        return x3;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setX3()
     * Description      This method sets the value of x3.
     * @param x3-double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setX3(double x3) {
        this.x3 = x3;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getY1()
     * Description      This method gets the value of y3.
     * @author          <i>Robert Tang</i>
     * @return double
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getY3() {
        return y3;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setY3()
     * Description      This method sets the value of y3.
     * @param y3-double
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setY3(double y3) {
        this.y3 = y3;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           toString()
     * Description      Override the default toString() method.
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public String toString() {
        return "Triangle{" + "x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", x3=" + x3 + ", y3=" + y3 + '}';
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           equals()
     * Description      Override the default equals() method.
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        if (Double.doubleToLongBits(this.x1) != Double.doubleToLongBits(other.x1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y1) != Double.doubleToLongBits(other.y1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x2) != Double.doubleToLongBits(other.x2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y2) != Double.doubleToLongBits(other.y2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x3) != Double.doubleToLongBits(other.x3)) {
            return false;
        }
        return Double.doubleToLongBits(this.y3) == Double.doubleToLongBits(other.y3);
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           hashCode()
     * Description      Override the default hashCode() method.
     * @author          <i>Robert Tang</i>
     * Date 5/15/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.x1) ^ (Double.doubleToLongBits(this.x1) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.y1) ^ (Double.doubleToLongBits(this.y1) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.x2) ^ (Double.doubleToLongBits(this.x2) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.y2) ^ (Double.doubleToLongBits(this.y2) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.x3) ^ (Double.doubleToLongBits(this.x3) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.y3) ^ (Double.doubleToLongBits(this.y3) >>> 32));
        return hash;
    }
    
    
}
