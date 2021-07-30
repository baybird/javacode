package SortingSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Binary Search
 *
 * Locates a target value in a sorted array/list by successively eliminating
 * half of the array from consideration.
 *
 * O(log N)
 *
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        searchString();
    }

    private static void searchString() {
        String fileLocation = "./src/SortingSearching/terms.txt";
        try {
            List<String> items = loadData(fileLocation);
            String term = "calculus";
            System.out.println(items);

            int result = binarySearch(items, term);
            System.out.println("Searching for keyword \"" + term + "\", found at " + result);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> loadData(String fileLocation) throws FileNotFoundException {
        Set<String> setItems = new HashSet<>();
        Scanner input = new Scanner(new File(fileLocation));
        while (input.hasNext()) {
            String next = input.next().trim().toLowerCase();
            setItems.add(next);
        }

        List<String> items = new ArrayList<>();
        for (String setItem : setItems) {
            items.add(setItem);
        }
        Collections.sort(items);

        return items;
    }

    private static int binarySearch(List<String> items, String term) {
        int min = 0;
        int max = items.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            int compareRes = items.get(mid).compareToIgnoreCase(term);

            if (compareRes < 0) {
                min = mid + 1;
            } else if (compareRes > 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static void searchInt() {
        int[] elements = {-30, -9, -6, -4, -2, -1, 0, 2, 4, 10, 12, 17, 22, 30};
        int testTerm = -5;

        int index = Arrays.binarySearch(elements, testTerm);
        System.out.println(testTerm + " is found at index " + index);

        index = binarySearch(elements, testTerm);
        System.out.println(testTerm + " is found at index " + index);
    }

    public static int binarySearch(int[] items, int term) {
        int min = 0;
        int max = items.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (items[mid] > term) {
                max = mid - 1;
            } else if (items[mid] < term) {
                min = mid + 1;
            } else {
                return mid;
            }
        }

        // not found
        return -1;
    }
}
