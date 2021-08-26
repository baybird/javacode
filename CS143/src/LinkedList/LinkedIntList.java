package LinkedList;

/**
 *
 * @author robert
 */
public class LinkedIntList<T> {

    private ListNode<T> front;   // null for an empty list

    public LinkedIntList() {
        front = null;
    }

    /**
     * Write a method removeAll that removes all occurrences of a particular
     * value. For example, if a variable list contains the following values:
     *
     * [to, be, or, not, to, be] The call of list.removeAll("be"); would remove
     * all occurrences of the value "be" from the list, yielding the following
     * values:
     *
     * [to, or, not, to] If the list is empty or the value doesn't appear in the
     * list at all, then the list should not be changed by your method. You must
     * preserve the original order of the elements of the list.
     *
     * The example shown is a list of strings, but this is a generic linked list
     * class that can store any type of objects. Assume that you are adding this
     * method to the LinkedList<E> class as defined below:
     *
     */
    public void removeAll(T removeThis) {
        ListNode left = null;
        ListNode current = front;

        while (current != null) {
            if (current.data.equals(removeThis)) {
                if (left == null) {
                    front = front.next;
                } else {
                    left.next = current.next;
                }

                current = current.next;
            } else {
                // move to next node
                left = current;
                current = current.next;
            }
        }
    }

    /**
     * Write a method count that accepts an element value as a parameter and
     * returns the number of occurrences of that value in the list. For example,
     * suppose a variable named list stores the following sequence of elements:
     *
     * [one, two, three, two, four, two, five, two, two, six] A call of
     * list.count("two") should return 5 because there are five occurrences of
     * that value in the list. If the list does not contain the value at all,
     * return 0.
     *
     * The example shown is a list of strings, but this is a generic linked list
     * class that can store any type of objects. Assume that you are adding this
     * method to the LinkedList<E> class as defined below:
     */
    public int count(T findMe) {
        int times = 0;
        ListNode current = front;

        while (current != null) {
            if (current.data.equals(findMe)) {
                times++;
            }

            current = current.next;
        }

        return times;
    }

    /**
     * Write a method doubleList that doubles the size of a list by appending a
     * copy of the original sequence to the end of the list.
     *
     * For example, if a variable list stores this sequence of values:
     *
     * [1, 3, 2,7]
     *
     * And we make the call of list.doubleList(); then it should store the
     * following values after the call:
     *
     * [1, 3, 2, 7, 1, 3, 2, 7]
     *
     * Notice that it has been doubled in size by having the original sequence
     * appear two times in a row. You may not make assumptions about how many
     * elements are in the list. You may not call any methods of the class to
     * solve this problem. If the original list contains n nodes, then you
     * should construct exactly n nodes to be added.
     *
     * You may not use any auxiliary data structures to solve this problem (no
     * array, ArrayList, stack, queue, String, etc). Your method should run in
     * O(n) time where n is the number of nodes in the list.
     *
     */
    public void doubleList() {
        ListNode current = front;
        ListNode last = front;

        LinkedIntList<T> list2 = new LinkedIntList<>();
        ListNode ref = list2.front;

        while (current != null) {
            list2.add((T) current.data);
            last = current;
            current = current.next;
        }

        if (list2.front != null) {
            last.next = list2.front;
        }
    }

    /**
     * Write a method transferFrom that accepts a second LinkedIntList as a
     * parameter and that moves values from the second list to this list. You
     * are to attach the second list's elements to the end of this list. You are
     * also to empty the second list. For example, suppose two lists store these
     * sequences of values:
     *
     * list1: [8, 17, 2, 4]
     *
     * list2: [1, 2, 3]
     *
     * The call of list1.transferFrom(list2); should leave the lists as follows:
     *
     * list1: [8, 17, 2, 4, 1, 2, 3]
     *
     * list2: []
     *
     * The order of the arguments matters; list2.transferFrom(list1); would have
     * left the lists as follows:
     *
     * list1: []
     *
     * list2: [1, 2, 3, 8, 17, 2, 4]
     *
     * Either of the two lists could be empty, but you can assume that neither
     * list is null. You are not to create any new nodes. Your method should
     * simply change links of the lists to join them together.
     *
     * @param list
     */
    public void transferFrom(LinkedIntList list) {
        if (front == null) {
            front = list.front;
        } else if (list != null) {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = list.front;
        }

        list.front = null;
    }

    // post: Add a new node to the end of the list.
    public void add(T value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new ListNode(value);
        }

    }

    // post: return a string of the node list
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (front != null) {
            sb.append(front.data);

            ListNode currNode = front.next;
            while (currNode != null) {
                sb.append(", ").append(currNode.data);
                currNode = currNode.next;
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
