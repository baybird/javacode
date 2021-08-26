package LinkedList;

/**
 *
 * @author robert
 */
public class PlayNodes {

    public static void main(String[] args) {
        updateAllValuesInNodeList();
    }

    /**
     * Write the code necessary to convert the following sequence of ListNode
     * objects:
     *
     * list -> [5] -> [4] -> [3] /
     *
     * Into this sequence of ListNode objects:
     *
     * list -> [3] -> [4] -> [5] /
     */
    public static void reverseNodeSequence() {
        ListNode list = new ListNode(5);
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);
        System.out.println(list);

        ListNode list2 = list; // back up
        list = list.next.next; // front->3
        list2.next.next = null;// dereference 
        list.next = list2.next;// front->3->4
        list2.next = null;     // dereference
        list.next.next = list2;// front->3->4->5
        System.out.println(list);
    }

    /**
     * Write the code necessary to convert the following sequence of ListNode
     * objects:
     *
     * list -> [5] -> [4] -> [3] /
     *
     * Into these sequences of ListNode objects:
     *
     * list -> [3] -> [5] /
     *
     * list2 -> [4] -> [3] -> [5] /
     */
    public static void test2() {
        ListNode list = new ListNode(5);
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);

        ListNode backup = list;
        ListNode list2 = list.next;
        list = backup.next.next;
        backup.next = null;
        list.next = backup;
        list2.next.next = backup;
        System.out.println("list:" + list);
        System.out.println("list2:" + list2);

    }

    /**
     * Write the code necessary to convert the following sequence of ListNode
     * objects:
     *
     * list -> [7] -> ... -> [16] /
     *
     * Into this sequence of ListNode objects:
     *
     * list -> [42] -> ... -> [42] /
     *
     * (In other words, set the value of every node to be 42.)
     */
    public static void updateAllValuesInNodeList() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        System.out.println("list: " + list);

        // 1 -> 2 -> 3 -> 4
        // left         mid             right
        // null         1               2->3->4
        // 1            2               3->4
        // 2->1         3               4
        // 3->2->1      4               null
        ListNode left, mid, right;
        mid = list;
        left = null;
        while (mid != null) {
            mid.data = 42;
            right = mid.next;
            mid.next = left;
            left = mid;
            mid = right;
        }
        list = left;
        System.out.println("list: " + list);
    }

    //Write the code necessary to convert the following sequence of ListNode objects:
    //list -> [7] -> ... -> [3] /
    //Into this sequence of ListNode objects:
    //list -> [7] -> ... -> [42] /
    //(In other words, set the value of the last node to be 42.)
    public static void updateTheLastNode() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        System.out.println("list: " + list);

        // 1 -> 2 -> 3 -> 4
        // left         mid             right
        // null         1               2->3->4
        // 1            2               3->4
        // 2->1         3               4
        // 3->2->1      4               null
        ListNode left, mid, right;
        mid = list;
        left = null;

        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }

        int i = 0;
        while (mid != null) {
            i++;

            right = mid.next;
            mid.next = left;
            if (i == len) {
                mid.data = 42;
            }
            left = mid;
            mid = right;
        }
        list = left;

        mid = list;
        left = null;
        while (mid != null) {
            right = mid.next;
            mid.next = left;
            left = mid;
            mid = right;
            i++;
        }
        list = left;
        System.out.println("list: " + list);

    }
}
