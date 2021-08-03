package StackAndQueue;

import java.util.*;

/**
 *
 * @author robert
 */
public class Stutter {

    public static void main(String[] args) {
        Stutter app = new Stutter();

        Stack<Integer> st = new Stack<>();
        st.add(3);
        st.add(7);
        st.add(1);
        st.add(14);
        st.add(9);
        app.stutter(st);
        System.out.println(st);
    }

    public void stutter(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int num = st.pop();
            stutter(st);;
            st.push(num);
            st.push(num);
        }

    }
}
