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
public class Pow {

    static int n = 0;

    public static void main(String[] args) {
        System.out.println(pow(2, 16));
    }

    public static int pow(int base, int exp) {
        n += 1;
        if (exp == 0) {
            return 1;
        } else if (exp % 2 == 0) {
            return pow(base * base, exp / 2);
        } else {
            return base * pow(base, exp - 1);
        }

    }
}
