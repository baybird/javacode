/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingSearching;

import java.util.*;

/**
 *
 * @author robert
 */
public class SelectionSort {

    // selection sort
    // merge sort
    // sorting methods in Java
    // Arrays & Collections classes in java.util
    public static void main(String[] args) {
        int[] numbers = {29, 17, 3, 94, 46, 8, -4, 12};
        selectionSort(numbers);
    }

    public static void javaSorts() {
        String[] elements = {"foo", "bar", "baz", "cat", "bee", "daa"};

        List<String> words = new ArrayList<String>();
        for (String element : elements) {
            words.add(element);
        }

        Arrays.sort(elements);
        System.out.println(Arrays.toString(elements));

        Collections.sort(words);
        System.out.println(words);
    }

    public static void selectionSort(int[] items) {
        for (int i = 0; i < items.length; i++) {

            // find index of smallest remaining value
            int min = i;
            for (int j = i+1; j < items.length; j++) {
                if (items[j] < items[min]) {
                    min = j;
                }
            }

            // swap smallest value to its proper place, a[i]
            swap(items, i, min);
            
            System.out.println(Arrays.toString(items));
        }

    }

    public static void swap(int[] items, int index, int minIndex) {
        if (index != minIndex) {
            int minValue = items[minIndex];
            items[minIndex] = items[index];
            items[index] = minValue;
        }
    }
}
