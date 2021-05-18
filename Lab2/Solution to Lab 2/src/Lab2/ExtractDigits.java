package Lab2;

import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        ExtractDigits
 * File         ExtractDigits.java
 * Description  1. Extract and display the four digits of a four-digit number.
 *              2. This program also demonstrates the use of args String array.
 *              3. This program also allows to extract input of any number of 
 *                 digits.
 *                 To switch between 4-digis or any-digis, change choiceOfAlgorithm
 *                 to 1 or 2, at line 65.
 * @author      <i>Robert Tang</i>
 * Environment  Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         4/15/2021
 * @version     1.0.0
 * @see         javax.swing.JOptionPane
 * History Log
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class ExtractDigits {

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
    public static void main(String[] args) {
        // check for valid number of arguments at command prompt.
        // must 2 arguments
        if (args.length < 2) {
            System.out.println("usage: java ExtractDigits <month> <year>");
            System.exit(1);
        }

        // convert args into integers
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        if (month < 1 || month > 12) { // invalid month
            System.out.println("Month must be between 1 and 12");
            System.exit(1);
        }
        if (year < 1970) {
            // Illegal year, 1970 is UNIX’s birth year
            System.out.println("Year must be greater than 1969");
            System.exit(1);
        }

        // display inputs
        System.out.println("The month you entered is " + month);
        System.out.println("The year you entered is " + year);

        // Choose an algorithm
        // Solution for Problem I - 3. How would you change the program to allow
        // input of any number of digits in a number?
        
        final int choiceOfAlgorithm = 1; // allow input of any number of digits
        //final int choiceOfAlgorithm = 2; // allow input of 4-digit number.

        StringBuffer message = new StringBuffer();
        if (choiceOfAlgorithm == 1) {
            message.append("Please enter a number of any number of digits");
        } else {
            message.append("Please enter a 4-digit number");
        }

        // read input from JOptionPane
        String input = JOptionPane.showInputDialog(message);

        // I added this line to avoids an error message due to empty input.
        if (input.isEmpty() != true) { // if input is not empty.
            StringBuffer output = new StringBuffer();
            output.append("The digits of ").append(input).append(" are ");

            if (choiceOfAlgorithm == 1) {
                // this is the solution for: 3. How would you change the program to
                // allow input of any number of digits in a number?
                final int stringLength = input.length();
                for (
                    int currentIndex = 0;
                    currentIndex < stringLength;
                    currentIndex += 1
                ) {
                    output.append(input.charAt(currentIndex));

                    if (stringLength == currentIndex + 1) {
                        output.append(".");
                    } else {
                        output.append(", ");
                    }
                }
            } else {
                // algorithm for handling only 4 digits.
                int number = Integer.parseInt(input);

                // thousand's digit
                output.append(number / 1000).append(",");
                number %= 1000;

                // hundred’s digit
                output.append(number / 100).append(",");
                number %= 100;

                // ten's digit
                output.append(number / 10).append(",");
                number %= 10;

                // the unit's digit
                output.append(number).append(".");
            }

            // display output in console
            System.out.println(output);

            // display output in a MessageDialog
            JOptionPane.showMessageDialog(null, output);
        }

        System.exit(0);
    }
}
