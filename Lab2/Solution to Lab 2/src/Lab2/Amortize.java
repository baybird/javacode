package Lab2;

import java.text.NumberFormat;
import java.util.Scanner;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        Amortize
 * File         Amortize.java
 * Description  Calculates monthly payment of given loan amount, interest,
 *              and years of loan.
 * @author      <i>Robert Tang</i>
 * Environment  Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         4/15/2021
 * @version     1.0.0
 * @see         java.util.Scanner
 * History Log
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class Amortize {

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method         main()
     * Description    Displays individual digits from a user provided 4
     *                digits integer and accesses command-line arguments
     * @param         args are the command line strings
     * @author        <i>Robert Tang</i>
     * Date           4/15/2021
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[]) {

        // create decimal format for currency
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the loan amount in dollars > ");
        double loanAmount = keyboard.nextDouble(); // read a double value

        System.out.print("Enter the interest rate in percent > ");
        double interest = keyboard.nextDouble();

        System.out.print("Enter the number of years > ");
        double years = keyboard.nextDouble();

        System.out.print("The payment is: ");
        System.out.println(
            moneyFormat.format(payment(loanAmount, interest, years))
        );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method           payment()
     * Description      Does the magic calculation
     * @return          double
     * @param           amount double
     * @param           interest double
     * @param           years double
     * @author          <i>Robert Tang</i>
     * Date             4/16/2021
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    static double payment(double amount, double interest, double years) {
        double top = amount * (interest / 1200);
        double bot = 1 - Math.pow((1 + interest / 1200), years * (-12));
        return (top / bot);
    }
}
