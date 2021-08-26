class Node {

    public int data;
    public Node next;

    public Node() {
        this(0, null);
    }
    
    public Node(int input) {
        data = input;
    }
    
    public Node(int input, Node next) {
        this.data = input;
        this.next = next;
    }
}
