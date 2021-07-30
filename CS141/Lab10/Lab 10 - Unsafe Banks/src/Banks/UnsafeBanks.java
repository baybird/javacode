package Banks;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         UnsafeBanks.java
 * Project      Unsafe Banks
 * Description  A program to determine which of give five banks with some assest
 *              are unsafe: current balance plus its loans to other banks is below
 *              certain limit. Data is obtained from an exteranl Banks.txt file.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         6/10/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * @see java.io.File
 * @see java.text.DecimalFormat
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class UnsafeBanks {

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           main()
     * Description      main method of the unsafe bank application.
     * @author          <i>Robert Tang</i>
     * @param args the command line arguments Date 6/10/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static void main(String[] args) {
        StringBuilder result = checkUnsafeBanks();
        System.out.println(result.toString());
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           main()
     * Description      Determines which bank is unsafe by using 2-D array for
     *                  loans given and 1-D array for its blance.
     * @return result - StringBuilder 
     * @author          <i>Robert Tang</i>
     * Date 6/10/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public static StringBuilder checkUnsafeBanks(){
        DecimalFormat dollars = new DecimalFormat("$#,##0.00");
        StringBuilder result = new StringBuilder();
        
        try {
            String fileName = "src/Banks/Banks.txt";
            File file = new File(fileName);
            Scanner filePointer = new Scanner(file);
            Scanner input = new Scanner(System.in);
            result.append("Welcome to Unsafe Banks Test.\n");
            result.append("A bank is unsafe if the bank's total assests are below\n");
            result.append("certain limit.\n\n");
            
            // enter a number of banks
            int n = filePointer.nextInt();  // input.nextInt();
            
            // enter a limit
            double limit = filePointer.nextDouble(); // input.nextDouble();
            result.append("There are ").append(n).append(" banks with a limit of ").append(dollars.format(limit)).append(".");
            
            double[] balances = new double[n]; // Balance for each bank
            double[][] loan = new double[n][n]; // loan[i][j] is the amount bank i loans to bank j
            
            for (int i = 0; i < n; i++) {
                // Bank i's balance
                balances[i] = filePointer.nextDouble(); // input.nextDouble(); 
                
                // number of banks borrowing from bank i
                int numberOfBorrowers = filePointer.nextInt();
                result.append("\n\nBank # "+i+" has balance = " + 
                    dollars.format(balances[i]) + " and it has " +
                    numberOfBorrowers + ((numberOfBorrowers == 1)? " borrower.":" borrowers."));
                
                for (int j = 0; j < numberOfBorrowers; j++) {
                    int k = filePointer.nextInt();
                    loan[i][k] = filePointer.nextDouble(); // the loan amount of Bank k borrowing from bank i
                    result.append("\n\tBank # "+ k +" borrowed " + dollars.format(loan[i][k]));
                }
                
            }// end for
            
            double[] asset = new double[n]; // asset[i] is bank i's total asset
            boolean[] isSafe = new boolean[n]; // All banks are safe initially
            
            for (int i = 0; i < n; i++) {
                isSafe[i] = true;
            }// end for
            
            result.append("\n\nUnsafe banks: ");
            boolean newUnsafeFound = true; // Indicates whether a new unsafe bank is discovered
            while (newUnsafeFound) {                
                newUnsafeFound = false; // Assume no new unsafe banks are found
                for (int i = 0; i < n; i++) {
                    asset[i] = balances[i];
                    for (int j = 0; j < n; j++) {
                        asset[i] += loan[i][j];
                    }
                    
                    if(isSafe[i] && asset[i] < limit){
                        isSafe[i] = false;
                        newUnsafeFound = true;
                        // Remove bank i is unsafe
                        result.append(i + " ");
                        
                        for (int k = 0; k < n; k++) {
                            loan[k][i] = 0; // Bank i's borrowed loans are gone and is unsafe
                        }
                    }
                }
            }
            
            result.append("\n");
            filePointer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }// end func

}
