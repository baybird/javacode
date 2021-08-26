package LinkedList;

/**
 *
 * @author robert
 */
public class PlayLinkedIntList {

    public static void main(String[] args) {
        testTransferFrom();
    }

    public static void testTransferFrom() {
        LinkedIntList<Integer> list = new LinkedIntList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        LinkedIntList<Integer> list2 = new LinkedIntList<>();
        list2.add(5);
        list2.add(6);
        list2.add(7);

        System.out.println("orginal list: " + list);
        list.transferFrom(list2);
        System.out.println("after: " + list);

    }

    public static void testCount() {
        LinkedIntList<String> list = new LinkedIntList<>();
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("two");
        list.add("five");

        System.out.println(list + " has " + list.count("two") + " of two: ");
    }

    public static void testRemoveAll() {
        LinkedIntList<String> list = new LinkedIntList<>();
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("two");
        list.add("five");

        System.out.println("orginal list: " + list);
        list.removeAll("two");
        System.out.println("after removed two: " + list);
    }
}
