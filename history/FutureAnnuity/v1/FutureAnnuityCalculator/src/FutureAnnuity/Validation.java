package FutureAnnuity;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Validation.java
 * Project      Future Annuity
 * Description  This class provides methods to validates the user inputs.
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
public class Validation {
    
    private StringBuffer errorMsg = new StringBuffer();
    private Double periodicPayment = 0.0;
    private Integer compoundsPerYear = 0;
    private Integer years = 0;
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Validation()
     * Description      Default constractor
     * @author          <i>Robert Tang</i>
     * Date 4/23/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Validation(){
        
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Validation()
     * Description      Overloadded constractor
     * @author          <i>Robert Tang</i>
     * @param periodicPaymentString-string
     * @param compoundsPerYearString-string
     * @param yearsString-string
     * Date 4/23/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public Validation(String periodicPaymentString, String compoundsPerYearString, String yearsString){
        
        if (periodicPaymentString.length() > 0) {
            this.periodicPayment = Double.parseDouble(periodicPaymentString);
        } 
        
        if (compoundsPerYearString.length() > 0) {
            this.compoundsPerYear = Integer.parseInt(compoundsPerYearString);
        } 
        
        if (yearsString.length() >0) {
            this.years = Integer.parseInt(yearsString);
        }
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           isGood()
     * Description      This method returns the validation result
     * @author          <i>Robert Tang</i>
     * @return the validation result
     * Date 4/23/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public boolean isGood(){
        if (this.periodicPayment <= 0) {
            this.errorMsg.append("PERIODIC_PAYMENT_IS_WRONG");
            return false;
            
        } else if (this.compoundsPerYear <=0) {
            this.errorMsg.append("COMPOUNDINGS_IS_WRONG");
            return false;
            
        } else if (this.years <= 0) {
            this.errorMsg.append("YEARS_IS_WRONG");
            return false;
        }
        
        return true;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getErrorMsg()
     * Description      This method returns an error message to indicates 
     *                  which of these data is wrong.
     * @author          <i>Robert Tang</i>
     * @return the error message
     * Date 4/23/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getErrorMsg(){
        return this.errorMsg.toString();
    }
}
