package Project3;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Transaction.java
 * Project      At the Movies
 * Description  This class provides computation methods for transaction history.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         6/9/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Transaction {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    private final DecimalFormat dollarFormat = new DecimalFormat("$#,##0.00");
    private final int MAX_SPACES = 46;
    private final ArrayList<MovieBasic> history;
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Transaction()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    Transaction() {
        history = new ArrayList<>();
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           add()
     * Description      Add a movie transation into the transation history.
     * @param movieName-string
     * @param movieTime-string
     * @param adultTickets-int
     * @param childNSeniorTickets-int
     * @param amount-double
     * @param tax-double
     * @param amountDue-double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void add(String movieName, String movieTime, int adultTickets,
            int childNSeniorTickets, double amount, double tax, double amountDue) {
        MovieBasic trans = new MovieBasic();

        trans.setMovieName(movieName);
        trans.setMovieTime(movieTime);
        trans.setAdultTickets(adultTickets);
        trans.setChildSeniorTickets(childNSeniorTickets);
        trans.setAmount(amount);
        trans.setTax(tax);
        trans.setAmountDue(amountDue);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String strDate = formatter.format(date).toString();
        trans.setTransactionTimeDate(strDate);

        history.add(trans);
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getTotalSales()
     * Description      Get the total sales of all transactions.
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getTotalSales() {
        double totalSales = 0;
        for (MovieBasic current : history) {
            totalSales += current.getAmountDue();
        }

        return totalSales;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           reset()
     * Description      Reset and clear the transaction history.
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void reset() {
        history.clear();
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           dispaly()
     * Description      Display all transactions.
     * @return bill-StringBuffer
     * @author          <i>Robert Tang</i>
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public StringBuffer dispaly() {

        StringBuffer content = new StringBuffer();

        for (MovieBasic next : history) {
            content.append("Transaction Date and Time: " + next.getTransactionTimeDate() + "\n");
            content.append(next.getMovieName() + "\n");
            content.append("Showing: " + next.getMovieTime() + "\n");

            content.append(padSpaces("# of Tickets: "
                    + (next.getAdultTickets() + next.getChildSeniorTickets()),
                    "Amount: " + String.valueOf(dollarFormat.format(next.getAmount())) + "\n"));

            content.append(padSpaces("# of Adult: "
                    + (next.getAdultTickets()),
                    "Tax: " + String.valueOf(dollarFormat.format(next.getTax())) + "\n"));

            content.append(padSpaces("# of Child/Senior: "
                    + (next.getChildSeniorTickets()),
                    "Total Cost: " + String.valueOf(dollarFormat.format(next.getAmountDue())) + "\n"));

            content.append("------------------------------------------------\n\n");
        }
        return content;
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           padSpaces()
     * Description      Adds blank spaces between two strings.
     * @author          <i>Robert Tang</i>
     * @param first
     * @param second
     * @return line-StringBuffer 
     * Date 4/30/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private StringBuffer padSpaces(String first, String second) {
        StringBuffer line = new StringBuffer(first);

        //find number of spaces needed to pad the string for right-justification
        int numSpaces = MAX_SPACES - first.trim().length() - second.trim().length();

        for (int i = 0; i < numSpaces; i++) {
            line.append(" ");	//add appropriate number of spaces
        }
        line.append(second.trim() + '\n');	//add second string

        return line;
    }
}
