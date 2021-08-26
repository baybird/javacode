package LinkedList;

public class ListNode <T> {
    public T data;   
    public ListNode next; 

    public ListNode() {
        this(null, null);
    }

    public ListNode(T data) {
        this(data, null);
    }

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(data);
        
        ListNode node = this;
        while (node.next != null) {   
            node = node.next;
            sb.append(" -> ").append(node.data);
        }
        
        return sb.toString();
    }
    
    
}
