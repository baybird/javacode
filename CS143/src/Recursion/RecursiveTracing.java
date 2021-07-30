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
public class RecursiveTracing {

    public static void main(String[] args) {
        mystery(749);
        
    }
    
    public static void mystery(int n) {
        
        if (n < 0) {
            mystery(-n);
        } else if (n < 10) {
            System.out.print(n);
        } else {
            mystery(n / 10);
            int digit = n % 10;
            System.out.print(", " + digit % 3);
        }
    }
}
