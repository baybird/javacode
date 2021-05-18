package Lab3;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Parcel.java
 * Project      Shipping Charges
 * Description  This class provides serveral methods related to the calculation
 *              of parcel shipping charges.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         4/23/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * @see javax.swing.JFrame
 * @see java.awt.Toolkit
 * @see java.awt.Color
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Parcel {

    // private instance variables and constants
    final double MAX_WEIGHT = 75;
    private int idNumber;  // parcel id number
    private byte pounds;    // weight in pounds
    private byte ounces;    // weight in ounces
    private byte region;    // region
    private String type;    // type of shipping

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Default constructor
     * Description      Creates an instance of a Parcel object with default
     *                  values for its fields.
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Parcel() {
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Overloaded constructor
     * Description      Creates an instance of a Parcel object with specified
     *                  parameters, and calls the setWeight() method for
     *                  validation and assignment
     * @param           idNumber--int
     * @param pounds--byte
     * @param ounces--byte
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Parcel(int idNumber, byte pounds, byte ounces) {
        idNumber = 0;
        setWeight((byte) 0, (byte) 0); // need to typecast 0 (int) to byte
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Overloaded constructor
     * Description      Creates an instance of a Parcel object with specified
     *                  parameters, and calls the setWeight() method for
     *                  validation and assignment
     * @param           idNumber--int
     * @param pounds--byte
     * @param ounces--byte
     * @param region--byte
     * @param type--byte
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Parcel(int idNumber, byte pounds, byte ounces, byte region, String type) {
        idNumber = 0;
        setWeight((byte) pounds, (byte) ounces);  
        this.region = region;
        this.type = type;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setWeight()
     * Description      Performed validation on range
     * @param           lb--byte
     * @param oz--byte
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private void setWeight(byte lb, byte oz) {
        if ((lb >= 0 && lb <= MAX_WEIGHT) && (oz >= 0 && oz < 16)) {
            this.pounds = lb;
            this.ounces = oz;
        } else {
            pounds = 0;
            ounces = 0;
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateWeight()
     * Description      To convert all weight in ounces.
     * @return          int--Weight of parcel in ounces
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private int calculateWeight() {
        return (this.pounds * 16 + ounces);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateCharges()
     * Description      Calculate shipping charges.
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double  calculateCharges() {
        // declaration of constants
        final double REGION_1 = 0.37;
        final double REGION_2 = 0.38;
        final double REGION_3 = 0.41;
        final double REGION_4 = 0.51;
        final double REGION_5 = 0.56;
        final double REGION_6 = 0.61;
        final double REGION_7 = 0.67;
        final double REGION_8 = 0.93;

        // type of delivery surcharges 
        final double NEXT_DAY = 20.0, EXPRESS = 10.0, PRIORITY = 5.0;

        // declaration of variables
        double charges = 0.0, rate = REGION_1;

        // calculate charges
        switch (region) {
            case 1:
                rate = REGION_1;
                break;
            case 2:
                rate = REGION_2;
                break;
            case 3:
                rate = REGION_3;
                break;
            case 4:
                rate = REGION_4;
                break;
            case 5:
                rate = REGION_5;
                break;
            case 6:
                rate = REGION_6;
                break;
            case 7:
                rate = REGION_7;
                break;
            case 8:
                rate = REGION_8;
                break;
            default:
                rate = REGION_1;
        }

        // calculate charge based on weight
        int weightInOunces = this.calculateWeight();
        charges = weightInOunces * rate;

        // add surcharges for type of shipment 
        if (type.equals("Next Day")) {
            charges += NEXT_DAY;
        } else if (type.equals("Priority")) {
            charges += PRIORITY;
        } else if (type.equals("Express")) {
            charges += EXPRESS;
        }
        
        return charges;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Overridden toString() method to display the Parcel
     *                  information.
     * Description      Calculate shipping rate.
     * @return          String--the parcel id, and weight in pounds and ounces
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public String toString() {
        String boxInfo = "Parcel ID = " + this.idNumber + ". ";
        boxInfo += "It weighs " + pounds + " pounds and " + ounces;
        boxInfo += " ounces.";

        return boxInfo;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Equals method to check if two parcels are identical.
     *                  Uses instanceof operator to check if obj is of type
     *                  Parcel
     * Description      Calculate shipping rate.
     * @param           obj
     * @return boolean
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Parcel) {
            Parcel temp = (Parcel) obj;
            return (temp.idNumber == this.idNumber) && (temp.ounces == this.pounds)
                    && (temp.ounces == this.ounces);
        } else {
            return false;
        }
    }

}
