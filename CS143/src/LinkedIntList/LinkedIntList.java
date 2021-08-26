/**
 *
 * @author robert
 */
public class LinkedIntList implements IntList {

    private Node front;

    public LinkedIntList() {
        front = null;
    }

    // post: Add a new node to the end of the list.
    @Override
    public void add(int value) {
        if (front == null) {
            front = new Node(value);
        } else {
            Node current = front;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(value);
        }

    }
    
    // post: insert a new node at the given index
    @Override
    public void add(int index, int value) {
        if (index == 0) {
            front = new Node(value, front);
        } else {
            Node current = getNodeAtIndex(index - 1);
            current.next = new Node(value, current.next);
        }
    }
    
    // post: get node located at the given index.
    public Node getNodeAtIndex(int index) {
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("index: " + index);
        }
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }
    
    // post: remove node from the given index
    @Override
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            Node current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }
    }
   
    // post: return the length of the node list.
    @Override
    public int size() {
        int num = 0;
        Node current = front;
        while (current != null) {
            current = current.next;
            num++;
        }

        return num;
    }

    // post: get the value located at the input index.
    @Override
    public int get(int index) {
        Node current = front;
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.next;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        return current.data;
    }

    // post: get the index of the input value
    @Override
    public int indexOf(int value) {
        Node current = front;
        int index = 0;
        while (current != null) {
            if (value == current.data) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }
   
    // post: insert another node list to the given index
    @Override
    public void insertList(int index, LinkedIntList list) {
        if (index == 0) {
            front = list.getNodeAtIndex(0);
        } else {
            Node current = getNodeAtIndex(index - 1);
            Node restNodes = current.next;

            Node otherNodes = list.getNodeAtIndex(0);
            current.next = otherNodes;
            
            Node endNode = getNodeAtIndex(size() -1);
            endNode.next = restNodes;
        }
    }
   
    // post: return a string of the node list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (front != null) {
            sb.append(front.data);

            Node currNode = front.next;
            while (currNode != null) {
                sb.append(", ").append(currNode.data);
                currNode = currNode.next;
            }
        }

        sb.append("]");

        return sb.toString();
    }
   
    // post: compare two node lists and return true if both list equal to each other, otherwise return false.
    public boolean equals(LinkedIntList obj) {
        Node curNode = front;

        int index = 0;

        if (front == null && obj.getNodeAtIndex(index) != null) {
            return false;
        }

        while (curNode != null) {
            if (curNode.data != obj.get(index)) {
                return false;
            }
            curNode = curNode.next;
            index++;
        }
        return true;
    }

}
