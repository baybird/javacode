package FutureAnnuity;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Annuity.java
 * Project      Future Annuity
 * Description  This class provides methods for calculating the futurn annuity,
 *              the total of payments, and the total of interest earned.
 *
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         4/23/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * @see javax.swing.JDialog
 * @see java.awt.Toolkit
 * @see java.awt.Color
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Annuity {

    // Declare some vars 
    double periodicPayment;
    double interest;
    int compoundsPerYear;
    int years;
    int timesOfPayment;

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Annuity()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Annuity() {

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Annuity()
     * Description      Overloaded constructor
     * @author          <i>Robert Tang</i>
     * @param periodicPaymentLocal-double
     * @param interestLocal-double
     * @param compoundsPerYearLocal-int
     * @param yearsLocal-int
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Annuity(double periodicPaymentLocal, double interestLocal, int compoundsPerYearLocal, int yearsLocal) {
        this.periodicPayment = periodicPaymentLocal;
        this.interest = interestLocal;
        this.compoundsPerYear = compoundsPerYearLocal;
        this.years = yearsLocal;

        this.timesOfPayment = compoundsPerYearLocal * yearsLocal;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateFutureAnnuity()
     * Description      This method computes the future annuity.
     * @author          <i>Robert Tang</i>
     * @return the calculation result of future annuity
     *
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double calculateFutureAnnuity() {
        // calculate future annuity balance         
        if (this.interest > 0) {
            double numerator = this.periodicPayment * (Math.pow(1 + (this.interest / this.compoundsPerYear), this.timesOfPayment) - 1);
            double denominator = this.interest / this.compoundsPerYear;
            return (numerator / denominator);
        } else {
            return this.calculateTotalPayment();
        }

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateTotalPayment()
     * Description      This method computes the total of payment
     * @author          <i>Robert Tang</i>
     * @return the result of total of payment
     *
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double calculateTotalPayment() {
        return (this.periodicPayment * (double) this.timesOfPayment);
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateInterest()
     * Description      This method computes the total of interest
     * @author          <i>Robert Tang</i>
     * @return the result of total of interest
     *
     * Date 4/19/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double calculateInterest() {
        return calculateFutureAnnuity() - calculateTotalPayment();
    }

}
