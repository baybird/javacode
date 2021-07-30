package Comparable;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author robert
 */
public class test {

    public static void main(String[] args) {

//        LibraryCard obj = new LibraryCard("Jane Doe", 2019);
//
//        System.out.println(obj.getAccountID());
//        System.out.println(obj);

        WaterBottle obj1 = new WaterBottle(0.9);
        WaterBottle obj2 = new WaterBottle(1);
        
        System.out.println(obj1.compareTo(obj2));
        
    }

    public static void arrayMystery(int[] a) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[a.length - 1 - i] - a[i - 1];
        }
    }
}
