package JavaCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ListSetMap {

    static final String fileLocation = "./src/JavaCollections/mobydick.txt"; //mobydick | short

    public static void main(String[] args) throws FileNotFoundException {
        //set();

        //wordCountWithMap();
        test();
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : list1) {
            set1.add(num);
        }

        for (int num : list2) {
            set2.add(num);
        }

        int count = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                count += 1;
            }
        }

        return count;

    }

    public static int numUnique(ArrayList<Integer> myList) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i < myList.size(); i++) {
            int num = myList.get(i);
            mySet.add(num);
        }

        return mySet.size();
    }

    private static void test() {
        Map<String, Integer> ages = new HashMap<String, Integer>();
        ages.put("Marty", 19);
        ages.put("Geneva", 2);
        ages.put("Vicki", 57);
        for (String name : ages.keySet()) { // Geneva -> 2
            int age = ages.get(name); // Marty -> 19
            System.out.println(name + " -> " + age); // Vicki -> 57
        }
    }

    private static void wordCountWithMap() throws FileNotFoundException {
        // map of (word, count) pairs
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();

        Scanner input = new Scanner(new File(fileLocation));
        while (input.hasNext()) {
            String word = input.next();
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                int oldValue = wordCounts.get(word);
                wordCounts.put(word, oldValue + 1);
            }
        }

        String term = "test";
        System.out.println(term + " occurs " + wordCounts.get(term));

        // loop over the map
        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            if (count >= 500) {
                System.out.println(word + ", " + count + " times");
            }
        }

    }

    private static void list() throws FileNotFoundException {
        // List would take 3 seconds to get finished
        ArrayList<String> words = new ArrayList<>();
        Scanner input = new Scanner(new File(fileLocation));
        while (input.hasNext()) {
            String word = input.next();
            if (!words.contains(word)) {
                words.add(word);
            }
        }
    }

    private static void set() throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner input = new Scanner(new File(fileLocation));
        while (input.hasNext()) {
            words.add(input.next());
        }
        System.out.println(words.size());
        System.out.println(words);
    }
}
