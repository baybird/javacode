package Recursion;

/**
 *
 * @author robert
 */
public class Decimal2Binary {
    
    public static void main(String[] args) {
        printBinary(225);
    }
    
    public static void printBinary(int n) {
        if(n < 2){
            System.out.print(n);
        }
        else {
            printBinary(n / 2);
            printBinary(n % 2);
        } 
    }
}
/*
11100001
*/