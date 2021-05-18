package Lab4;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         DentalBill.java
 * Project      Lab 4
 * Description  This class provides the functionlities for computing dental bill.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         4/30/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * @see javax.swing.JDialog
 * @see java.awt.Toolkit
 * @see java.awt.Color
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class DentalBill {
    // class constants

    private static final double CLEANING = 135.0,
            CAVITY = 170.0,
            XRAY = 85.0,
            FLUORIDE = 35.0,
            ROOT = 900.0;

    private double total = 0.0;	// sum of all services provided

    private StringBuffer display = new StringBuffer();

    private NumberFormat dollars = NumberFormat.getCurrencyInstance();

    //instance variables
    private String patientName;
    private boolean cleaning;
    private boolean cavity;
    private boolean xray;
    private boolean fluoride;
    private boolean rootCanal;

    private double otherAmount;
    private String otherName;

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           DentalBill()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public DentalBill() {
        this.patientName = "";
        this.cleaning = false;
        this.cavity = false;
        this.xray = false;
        this.fluoride = false;
        this.rootCanal = false;
        this.otherAmount = 0.0;
        this.total = 0.0;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateDentalBill()
     * Description      method for calculating dental bill.
     * @author          <i>Robert Tang</i>
     * @param patientName-boolean
     * @param cleaning-boolean
     * @param cavity-boolean
     * @param xray-boolean
     * @param fluoride-boolean
     * @param rootCanal-boolean
     * @param otherAmount Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void calculateDentalBill(String patientName, boolean cleaning, boolean cavity, boolean xray, boolean fluoride, boolean rootCanal, double otherAmount) {
        this.patientName = patientName;
        this.cleaning = cleaning;
        this.cavity = cavity;
        this.xray = xray;
        this.fluoride = fluoride;
        this.rootCanal = rootCanal;
        this.otherAmount = otherAmount;

        this.total = 0.0;

        if (this.cleaning) {
            this.total += CLEANING;
        }

        if (this.cavity) {
            this.total += CAVITY;
        }

        if (this.xray) {
            this.total += XRAY;
        }

        if (this.fluoride) {
            this.total += FLUORIDE;
        }

        if (this.rootCanal) {
            this.total += ROOT;
        }

        this.total += this.otherAmount;

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAmount()
     * Description      Get the total of amount of a dental bill.
     * @author          <i>Robert Tang</i>
     * @return total-double
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getAmount() {
        return this.total;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           toString()
     * Description      Overrides the toString() method
     * @author          <i>Robert Tang</i>
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public String toString() {
        return "Patient " + patientName + " has a total fill of " + dollars.format(this.getAmount());
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           displayBill()
     * Description      Appends the result of a dental bill to StringBuffer.
     * @author          <i>Robert Tang</i>
     * @return displa-StringBuffer
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public StringBuffer displayBill() {
        display.delete(0, display.length());

        display.append(padSpaces("Patient", patientName));
        display.append('\n');
        if (cleaning) {
            display.append(padSpaces("Cleaning", dollars.format(CLEANING)));
        }

        if (cavity) {
            display.append(padSpaces("Cavity", dollars.format(CAVITY)));
        }

        if (xray) {
            display.append(padSpaces("X-Ray", dollars.format(XRAY)));
        }

        if (fluoride) {
            display.append(padSpaces("Fluoride", dollars.format(FLUORIDE)));
        }

        if (rootCanal) {
            display.append(padSpaces("Root canal", dollars.format(ROOT)));
        }

        if (otherAmount > 0.0) {
            display.append(padSpaces("Other", dollars.format(this.otherAmount)));
        }

        display.append("-------------------------\n");
        display.append(padSpaces("Total", dollars.format(this.getAmount())));

        return display;

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           padSpaces()
     * Description      Adds blank spaces between two strings.
     * @author          <i>Robert Tang</i>
     * @param first
     * @param second
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private StringBuffer padSpaces(String first, String second) {

        final int MAX_SPACES = 25;
        StringBuffer line = new StringBuffer(first);

        //find number of spaces needed to pad the string for right-justification
        int numSpaces = MAX_SPACES - first.trim().length() - second.trim().length();

        for (int i = 0; i < numSpaces; i++) {
            line.append(" ");	//add appropriate number of spaces
        }
        line.append(second.trim() + '\n');	//add second string

        return line;

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           equals()
     * Description      Overrides the equals() method.
     * Date 4/30/2021
     * @author          <i>Robert Tang</i>
     * @param obj-object
     * @return boolean
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
        final DentalBill other = (DentalBill) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (this.cleaning != other.cleaning) {
            return false;
        }
        if (this.cavity != other.cavity) {
            return false;
        }
        if (this.xray != other.xray) {
            return false;
        }
        if (this.fluoride != other.fluoride) {
            return false;
        }
        if (this.rootCanal != other.rootCanal) {
            return false;
        }
        if (Double.doubleToLongBits(this.otherAmount) != Double.doubleToLongBits(other.otherAmount)) {
            return false;
        }
        if (!Objects.equals(this.patientName, other.patientName)) {
            return false;
        }
        if (!Objects.equals(this.otherName, other.otherName)) {
            return false;
        }

        return true;
    }

}
