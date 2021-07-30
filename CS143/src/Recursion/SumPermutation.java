package Recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * possible combination: f(x) = x! * 2^(x-1)
 * @author robert
 */
public class SumPermutation {

    static private Set<String> all = new HashSet<>();
    static int fitNums = 0;

    public static void main(String[] args) {
        permutations("123", "");
        System.out.println("all: " + all.size());
//        System.out.println(fitNums + "/" + all.size() + " (" + String.valueOf((fitNums * 1.0 / all.size() * 100)).substring(0, 5) + "%)");
    }

    private static void permutations(String input, String output) {
        if (input.length() == 0 && !all.contains(output)) {
            all.add(output);
//            System.out.println(output);
            System.out.println(output + "=" + evaluate(output));
//            int targetVal = 28;
//            if (evaluate(output) == targetVal) {
//                fitNums++;
//                System.out.println(output + " = " + targetVal);
//            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                String chosen = input.substring(i, i + 1);
                String rest = input.substring(0, i) + input.substring(i + 1);

                if (output.length() > 0) {
                    permutations(rest, output + "+" + chosen);
                    permutations(rest, output + "-" + chosen);
                } else {
                    permutations(rest, chosen);
                }
            }
        }
    }

    private static int evaluate(String input) {
        Stack<Integer> st = new Stack<>();

        while (!input.isEmpty()) {
            String current = input.substring(0, 1);
            if ("+".equals(current) || "-".equals(current)) {
                int next = Integer.valueOf(input.substring(1, 2));
                int num = st.pop();
                if ("+".equals(current)) {
                    st.push(num + next);
                } else if ("-".equals(current)) {
                    st.push(num - next);
                }
                input = input.substring(2);
            } else {
                st.push(Integer.valueOf(current));
                input = input.substring(1);
            }
        }

        return Integer.valueOf(st.pop());
    }
}
