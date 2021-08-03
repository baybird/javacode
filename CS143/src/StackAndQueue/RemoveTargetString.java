package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author robert
 */
public class RemoveTargetString {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.add("a");
        q.add("a");
        q.add("a");
        q.add("b");
        q.add("a");
        q.add("c");
        q.add("d");
        q.add("e");
        q.add("a");
        
        removeAll(q, "a");
        System.out.println(q);
    }
    
    public static void removeAll(Queue<String> myQ, String target) {
        int len = myQ.size();
        for (int i = 0; i < len; i++) {
            String str = myQ.remove();
            System.out.println("str: "+str);
            if(!str.equals(target)){
                myQ.add(str);
            }
        }
    }
}
