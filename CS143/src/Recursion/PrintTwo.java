package Recursion;

import java.lang.IllegalArgumentException;

/**
 *
 * @author robert
 */
public class PrintTwo {

    public static void main(String[] args) {
        test(80);
        test(5);
        test(6);
    }

    public static void test(int n) {
        System.out.print("printTwos(" + n + ") = ");
        printTwos(n);
        System.out.println();
    }

    public static void printTwos(int n){
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        else if(n % 4 == 0){
            System.out.print("2 * ");
            printTwos(n/4);
            System.out.print(" * 2");
        }
        else if(n % 2 == 0){
            System.out.print("2 * ");
            printTwos(n/2);
        }
        else{// odd numbers
            System.out.print(n);
        }
    }
}
