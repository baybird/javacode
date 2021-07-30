/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparable;

import interfaces.IDCard;

/**
 *
 * @author robert
 */
public class LibraryCard implements IDCard{
    private String name;
    private String acccountId;
    private int expiryYear;
    
    public LibraryCard(String studentName, int currentYear){
        name = studentName;
        
        // The account ID should be assigned as the first 3 letters of the 
        // owners name + "LIB" + the current year.
        acccountId = studentName.substring(0, 3) + "LIB" + currentYear;
        
        
        // The library card should expire in 2 years.
        expiryYear = currentYear + 2;
    }
   
    public String toString(){
        return name + " (card expires:"+ expiryYear + ")";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAccountID() {
        return acccountId;
    }

    @Override
    public int getExpiryYear() {
        return expiryYear;
    }
    
}
