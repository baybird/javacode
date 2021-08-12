package Recursion;

/**
 *
 * @author robert
 */
public class PrintStarts {
    public static void main(String[] args) {
        printStarts(8);
    }
    
    public static void printStarts(int n){
        if (n==1) {
            // base case
            System.out.println("*");
        }
        else{
            // recursive case
            System.out.print("*");
            printStarts(n-1);
        }    
    }
}
