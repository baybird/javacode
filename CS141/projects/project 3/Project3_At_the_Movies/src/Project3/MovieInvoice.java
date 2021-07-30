package Project3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         MovieInvoice.java
 * Project      At the Movies
 * Description  This class provides computation methods for single movie transaction.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/10/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class MovieInvoice extends MovieBasic {
    // declars the constans would be used for calculating movie transaction
    protected final double REGULAR_PRICE = 9.0, DISCOUNT_PRICE = 5.5, TAX_RATE = 0.089;
    protected final String MATINEE_TIME_PRIOR = "05:00 PM";
    protected final SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat("hh:mm aa");

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           MovieInvoice()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    MovieInvoice() {
        movieName = "";
        movieTime = "";
        adultTickets = 0;
        childSeniorTickets = 0;
        amount = 0;
        tax = 0;
        amountDue = 0;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMySimpleDateFormat()
     * Description      Get pre-defined simple data format
     * @return SimpleDateFormat
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public SimpleDateFormat getMySimpleDateFormat() {
        return mySimpleDateFormat;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateBill()
     * Description      Calculate customer bill and validate inputs.
     * @author          <i>Robert Tang</i>
     * @throws java.text.ParseException
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void calculateBill() throws ParseException {
        try {
            if (!getMoviePlacehold().equals(this.movieName)
                    && !getTimePlacehold().equals(this.movieTime)) {
                Date movieTimeDate = mySimpleDateFormat.parse(this.movieTime);
                Date matineeTime = mySimpleDateFormat.parse(this.MATINEE_TIME_PRIOR);

                this.amount = 0;
                this.tax = 0;
                this.amountDue = 0;

                // discount for matinee and midnight movies
                if (movieTimeDate.before(matineeTime)) { 
                    this.amount = this.adultTickets * this.DISCOUNT_PRICE;
                } else { // regular price for adult
                    this.amount = this.adultTickets * this.REGULAR_PRICE;
                }

                // Calculate child/senior amount
                this.amount += (this.childSeniorTickets * this.DISCOUNT_PRICE);

                // calculate tax
                this.tax = this.amount * this.TAX_RATE;

                // calculate amount due
                this.amountDue = this.amount + this.tax;
            }
        } catch (ParseException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
