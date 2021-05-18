package Project2;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         Invoice.java
 * Project      Alderwood Water and Waterwater District
 * Description  This class provides computation methods for customer invoice.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         5/10/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Invoice {
    final int MAX_SPACES = 40;
    String customerName;
    Integer totalUnits = -1;
    
    // Charges
    double waterCharge = 0.0, sewerCharge=0.0, totalCharge = 0.0;
    
    // content
    StringBuffer content = new StringBuffer();
    
    // Water Rates
    final double WATER_TIER1_RATE = 2.61, WATER_TIER2_RATE = 3.16, WATER_TIER3_RATE = 3.81; 
    final Integer WATER_TIER1_MIN = 4, WATER_TIER2_MIN = 14, WATER_TIER3_MIN = 30;

    // Wastewater rates
    final double WASTEWATER_TIER1_RATE = 106.28, WASTEWATER_TIER2_RATE = 138.18,WASTEWATER_TIER3_RATE = 167.7;
    final Integer WASTEWATER_TIER2_MIN = 4, WASTEWATER_TIER3_MIN = 18;
    
    // Base charge
    final double BASE_CHARGE = 33.0, BASE_COVERAGE = 4;
    
    // Franchise charge
    final double FRANCHISE_CHARGE = 6.44;
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Invoice()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    Invoice (){
        this.totalUnits = -1;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Invoice()
     * Description      Overloaded constructor
     * @author          <i>Robert Tang</i>
     * @param name-String
     * @param totalUnits-Integer
     * @throws Exception
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    Invoice (String name, Integer totalUnits) throws Exception{
        if(totalUnits < 0){
            throw new Exception("Presend reading cannot less than the previous reading.");
        }
        this.totalUnits = totalUnits;        
        this.customerName = name;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           calculateBill()
     * Description      Calculate customer bill and validate inputs.
     * @author          <i>Robert Tang</i>
     * @throws Exception
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void calculateBill() throws Exception{
        if(this.totalUnits > -1){
            // calculates sewer charge
            if(totalUnits > WASTEWATER_TIER3_MIN){
                this.sewerCharge = WASTEWATER_TIER3_RATE;
            }
            else if(totalUnits > WASTEWATER_TIER2_MIN){
                this.sewerCharge = WASTEWATER_TIER2_RATE;
            }
            else{
                this.sewerCharge = WASTEWATER_TIER1_RATE;
            }
            
            // calculates water charges
            Integer tierUnits = this.totalUnits;
            this.waterCharge=0; // first 4 ccf water is free
            
            if(tierUnits > WATER_TIER3_MIN){
                double charge = (tierUnits - WATER_TIER3_MIN) * WATER_TIER3_RATE;
                this.waterCharge += charge;
                tierUnits = WATER_TIER3_MIN;
            }
            if(tierUnits > WATER_TIER2_MIN){
                double charge = (tierUnits - WATER_TIER2_MIN) * WATER_TIER2_RATE;
                this.waterCharge += charge;
                tierUnits = WATER_TIER2_MIN;
            }
            if(tierUnits > WATER_TIER1_MIN){
                double charge = (tierUnits - WATER_TIER1_MIN) * WATER_TIER1_RATE;
                this.waterCharge += charge;
            }
            
            this.totalCharge = this.waterCharge + this.sewerCharge + this.BASE_CHARGE + this.FRANCHISE_CHARGE;
        }
        else{
            throw new Exception("Invalid total unit or you have not enter readings.");
        }
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           dispaly()
     * Description      Display a customer bill.
     * @return bill-StringBuffer
     * @author          <i>Robert Tang</i>
     * Date 5/3/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public StringBuffer dispaly() {
        this.content.delete(0, this.content.length());
        
        content.append(padSpaces("Customer", this.customerName));
        
        DateFormat dateFormat2 = new SimpleDateFormat("MMM d, yyyy");
        content.append(padSpaces("Date", dateFormat2.format(new Date())));        
        content.append("\n");
        
        
        DecimalFormat dollar = new DecimalFormat("$#,##0.00");        
        content.append(padSpaces("Water Charge", String.valueOf(dollar.format(this.waterCharge))));
        content.append(padSpaces("Sewer Charge", String.valueOf(dollar.format(this.sewerCharge))));
        
        content.append(padSpaces("Base Charge", String.valueOf(dollar.format(this.BASE_CHARGE))));
        content.append(padSpaces("Franchise Charge", String.valueOf(dollar.format(this.FRANCHISE_CHARGE))));
        
        StringBuffer breakLine = new StringBuffer();
        for (int i = 0; i < MAX_SPACES; i++) {
            breakLine.append("-");
        }
        content.append(breakLine.toString()+"\n");
        content.append(padSpaces("Total", String.valueOf(dollar.format(this.totalCharge))));
        content.append("\n");
        content.append("Note: this is a bi-monthly bill!");
        return this.content;
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
