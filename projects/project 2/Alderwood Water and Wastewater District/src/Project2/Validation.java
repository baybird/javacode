package Project2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Validation.java
 * Project      Alderwood Water and Waterwater District
 * Description  This class provides validation methods on validate customer's 
 *              street address, city, state, and zip code.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/10/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Validation {
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Validation()
     * Description      Default constractor.
     * @author          <i>Robert Tang</i>
     * @param evt
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    Validation() {
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           validateAddress()
     * Description      Regular expression for validating the stree address. 
     * @author          <i>Robert Tang</i>
     * @param address-String
     * @return boolean
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public boolean validateAddress(String address) {
        Pattern myPattern = Pattern.compile("^\\d{1,}\\s{1,}.{2,}\\s?");
        Matcher myMatcher = myPattern.matcher(address);
        return myMatcher.find();
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           validateCity()
     * Description      Regular expression for validating the city name. 
     * @author          <i>Robert Tang</i>
     * @param city-String
     * @return boolean
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public boolean validateCity(String city) {
        Pattern myPattern = Pattern.compile("\\D{2,}");
        Matcher myMatcher = myPattern.matcher(city);
        return myMatcher.find();
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           validateZip()
     * Description      Regular expression for validating the zip code. 
     * @author          <i>Robert Tang</i>
     * @param zip-String
     * @return boolean
     * Date 5/8/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    static public Boolean validateZip(String zip) {
        Pattern myPattern = Pattern.compile("^\\d{5}|\\d{5}\\.\\d{4}?");
        Matcher myMatcher = myPattern.matcher(zip);
        
        return myMatcher.find();
    }
}
