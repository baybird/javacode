package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Write a method splitStack that takes a stack of integers as a parameter and
 * splits it into negatives and non-negatives. The numbers in the stack should
 * be rearranged so that all the negatives appear on the bottom of the stack and
 * all the non-negatives appear on the top. In other words, if after this method
 * is called you were to pop numbers off the stack, you would first get all the
 * nonnegative numbers and then get all the negative numbers. It does not matter
 * what order the numbers appear in as long as all the negatives appear lower in
 * the stack than all the non-negatives. You may use a single queue as auxiliary
 * storage.
 *
 * @author robert
 */
public class SplitNegativeAndNonnegative {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.add(1);
        s.add(4);
        s.add(-11);
        s.add(1);
        s.add(6);
        s.add(-3);
        s.add(-2);
        splitStack(s);
        System.out.println(s);
    }
    

    public static void splitStack(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        int len = q.size();
        for (int i = 0; i < len; i++) {
            int num = q.remove();
            if (num < 0) {
                s.add(num);
            } else {
                q.add(num);
            }
        }

        while (!q.isEmpty()) {
            s.add(q.remove());
        }

    }

}
