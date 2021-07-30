package SortingSearching;

import java.util.Arrays;

/**
 *
 * @author robert
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = {29, 17, 3, 94, 46, 8, -4, 12, 11};
        System.out.println(Arrays.toString(numbers));
        
        mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] items) {
        // split array into two halves
        if (items.length >= 2) {
            int[] left = Arrays.copyOfRange(items, 0, items.length / 2);
            int[] right = Arrays.copyOfRange(items, items.length / 2, items.length);
            
            
            // recursivly sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            merge(items, left, right);
            
        }
    }
    
    public static void merge(int[] result, int [] left, int [] right) {
        int indexOfLeft = 0;    // left
        int indexOfRight = 0;   // right
        
        for (int i = 0; i < result.length; i++) {
            if((indexOfRight >= right.length) || 
                (indexOfLeft < left.length 
                && left[indexOfLeft] <= right[indexOfRight]))
            {
                result[i] = left[indexOfLeft];
                indexOfLeft++;
            }
            else{
                result[i]=right[indexOfRight];
                indexOfRight++;
            }
        }
        System.out.println("result:" + Arrays.toString(result));
        
    }
}
