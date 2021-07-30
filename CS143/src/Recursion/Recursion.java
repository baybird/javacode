/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author robert
 */
public class Recursion {

    public static void main(String[] args) {
        Recursion r = new Recursion();

//        System.out.println(r.multiplyEvens(2));
//        System.out.println(r.starString(2));
//        r.writeNums(5);
        r.writeSequence(5);
    }
    
    public void writeSequence(int n){
        if(n < 1){
            throw new IllegalArgumentException();
        }
        
        if(n==1){
            System.out.print("1");
            return;
        }
        else if(n==2){
            System.out.print("1 1");
            return;
        }
        
        int sides = (int) Math.ceil(n/2.0);
        System.out.print(sides+" ");
        writeSequence(n-2);
        System.out.print(" "+sides);
    }

    public void writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            System.out.print("1");
        } else {
            writeNums(n - 1);
            System.out.print(", " + n);
        }
    }

    public String starString(int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException();
        }

        if (exponent == 0) {
            return "*";
        }

        return starString(exponent - 1) + starString(exponent - 1);
    }

    public int multiplyEvens(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else if (n == 1) {
            return 2;
        }

        return multiplyEvens(n - 1) * 2 * n;
    }
}
