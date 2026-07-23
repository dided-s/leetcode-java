package medium._0430_Flatten_a_Multilevel_Doubly_Linked_List;

import annotations.Explore;
import annotations.Medium;
import utils.GeneralNode;

import java.util.Deque;
import java.util.LinkedList;

@Medium
@Explore("Linked List")
public class Solution {

    public Node flatten(Node head) {

        Node current = head;
        Deque<Node> stack = new LinkedList<>();

        while (current != null) {
            if (current.child != null) {
                if (current.next != null) stack.push(current.next);
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }

            if (current.next == null) {
                if (!stack.isEmpty()) {
                    current.next = stack.pop();
                    current.next.prev = current;
                }
            }

            current = current.next;
        }

        return head;
    }
}

class Node extends GeneralNode<Node> {
    public Node(int val) {
        this.val = val;
    }

    public Node prev;
    public Node child;
}