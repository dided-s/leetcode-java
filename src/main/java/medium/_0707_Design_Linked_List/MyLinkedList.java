package medium._0707_Design_Linked_List;

public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
    }

    public int get(int index) {
        int j = 0;
        Node current = head;

        while (current != null) {
            if (j == index) {
                return current.val;
            }
            current = current.next;
            j++;
        }

        return -1;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        Node current = head;

        if (current == null) {
            head = new Node(val);
            return;
        }

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) addAtHead(val);
        int j = 0;

        Node current = head;
        Node newIndexNode = new Node(val);

        while (current != null) {
            if (j == index - 1) {
                newIndexNode.next = current.next;
                current.next = newIndexNode;
                return;
            }
            current = current.next;
            j++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (index == 0) head = head.next;

        int j = -1;
        Node current = new Node(-1);
        current.next = head;

        while (current.next != null) {
            if (j == index - 1) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
            j++;
        }
    }

    public void print() {
        Node current = head;

        int i = 0;

        while (current != null) {
            System.out.println(i++ + ": " + current.val);
            current = current.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */