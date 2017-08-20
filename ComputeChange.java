// Counting Monetary Unit
// This section presents a program that breaks a large amount of money into smaller units.
// Suppose you want to develop a program that changes a given amount of money into smaller
// monetary units. The program lets the user enter an amount as a double value representing a
// total in dollars and cents, and outputs a report listing the monetary equivalent in the maximum
// number of dollars, quarters, dimes, nickels, and pennies, in this order, to result in the minimum
// number of coins.
// Date: 8/20/2017
// Author: Robert T.

import java.util.*;

public class ComputeChange {
    Scanner input = new Scanner(System.in);
    double amount;
    int remainAmout;
    Map<Integer, String> mUnit = new LinkedHashMap<Integer, String>();

    ComputeChange(){
        super();

        // initialize mUnit;
        mUnit.put(100, "dollar(s)");
        mUnit.put(25, "quarter(s)");
        mUnit.put(10, "dime(s)");
        mUnit.put(5, "nickel(s)");
        mUnit.put(1, "pennie(s)");
    }

    public static void main(String[] args){
        ComputeChange computechange = new ComputeChange();
        computechange.doComputeChange();
    }

    private void doComputeChange(){

        // ask user enter an amount
        System.out.println("Enter an amount in double, for example 1.36: ");
        amount = input.nextDouble();
        remainAmout = (int) (amount * 100);

        // declared and initialized a stack
        Stack stack = new Stack();

        for(int unit: mUnit.keySet()){
            int num = (remainAmout / unit);

            if(num >0){
                String desc = num +" "+ mUnit.get(unit);
                stack.push(desc);
                remainAmout = (int) (remainAmout % unit);
            }// end if
        }// end for

        System.out.println(stack);
    }
}
