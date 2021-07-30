package Dice;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * Class Die
 * File         Die.java
 * Description  A class representing a die used in a rolling dice simulation.
 *              Project Dice Simulation
 * Environment  Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/3/2020
 * @version:    1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Die {

    // Class instance variables
    int num = 0; // number rolled on the die

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor  Die()
     * Description  Default constructor. Sets die face to 1.
     * @see java.awt.Toolkit Date 4/3/2020 History Log 7/18/2018
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Die() {
        num = 1;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor  Die()
     * Description  Overloded constructor. Sets die face to num.
     * @param       num int
     * @see         java.awt.Toolkit Date 4/3/2020 History Log 7/18/2018
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Die(int num) {
        this.num = num;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       roll()
     * Description  method to rolls a die--returns the number rolled.
     * @see java.awt.Toolkit
     * @return num int 1-6 
     * Date 5/3/2020  
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static int roll() {
        return (int) Math.floor(6 * Math.random() + 1);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method roll()
     * Description Getter method to return the number on the die.
     * @see java.awt.Toolkit
     * @return num int 1-6 
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public int getSide() {
        return num;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method roll()
     * Description Setter method to set the number on the die with num.
     * @param num int
     * Date 5/3/2020 
     * @see java.awt.Toolkit 
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setSide(int num) {
        this.num = num;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method toString()
     * Description Method to display die.
     * @see java.awt.Toolkit 
     * Date 5/3/2020 
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Override
    public String toString() {
        return "Die{" + "num=" + num + '}';
    }
}
