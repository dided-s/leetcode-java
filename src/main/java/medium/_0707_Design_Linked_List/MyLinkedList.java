package medium._0707_Design_Linked_List;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Linked List")
public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        return getNodeAtIndex(index).val;
    }

    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size)
            return null;

        Node pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        if (head != null) head.prev = newHead;

        head = newHead;
        if (size == 0)
            tail = head;
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0)
            addAtHead(val);
        else {
            Node newTail = new Node(val);
            newTail.prev = tail;

            tail.next = newTail;
            tail = tail.next;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        } else if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node prevNode = getNodeAtIndex(index - 1);

            newNode.next = prevNode.next;
            if (prevNode.next != null) prevNode.next.prev = newNode;
            newNode.prev = prevNode;

            prevNode.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            if (head.next != null) head.next.prev = head;
            head = head.next;
        } else if (index == size - 1) {
            Node prevNode = getNodeAtIndex(index - 1);
            prevNode.next = null;
            tail = prevNode;
        } else {
            Node previousNode = getNodeAtIndex(index - 1);
            previousNode.next = previousNode.next.next;
        }
        size--;
    }

    public void print() {
        Node current = head;

        int i = 0;

        System.out.println("size: " + size);
        while (current != null) {
            System.out.println(i++ + ": " + current.val);
            current = current.next;
        }
    }

    public static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
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