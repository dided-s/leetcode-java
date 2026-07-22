package medium._0138_Copy_List_with_Random_Pointer;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Linked List")
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node original = head;

        // 1. Make copy nodes after original
        // node1 -> node2 -> node3 -> ...
        // node1 -> copyNode1 -> node2 -> copyNode2 -> node3 -> ...
        while (original != null) {
            Node copy = new Node(original.val);
            copy.next = original.next;
            original.next = copy;

            original = original.next.next;
        }

        original = head;

        // 2. Copy random links. We only need shift not null to next Node (copyNode)
        while (original != null) {
            if (original.random != null) {
                // original.next - copy of original node
                original.next.random = original.random.next;
            }

            original = original.next.next;
        }

        // 3. Skip odd nodes - save only copies
        Node copyHead = head.next;
        original = head;
        while (original != null && original.next != null) {
            Node copy = original.next;
            Node nextOriginal = original.next.next;

            if (nextOriginal != null) copy.next = nextOriginal.next;

            original.next = nextOriginal;
            original = original.next;
        }

        return copyHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}