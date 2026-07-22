package medium._138_Copy_List_with_Random_Pointer;

import annotations.Explore;
import annotations.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Medium
@Explore("Linked List")
public class Solution2 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node copyHead = new Node(-1);
        // toRandomNode: List.of(nodeWithRandom1, nodeWithRandom2...)
        Map<Node, List<Node>> toRandomMap = new HashMap<>();

        Node current = head;
        Node copyCurrent = copyHead;

        while (current != null) {
            Node copy = new Node(current.val);
            copyCurrent.next = copy;

            if (current.random != null) {
                if (!toRandomMap.containsKey(current.random)) {
                    toRandomMap.put(current.random, new ArrayList<>());
                }

                toRandomMap.get(current.random).add(copy);
            }
            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        copyHead = copyHead.next;

        current = head;
        copyCurrent = copyHead;
        while (current != null) {
            if (toRandomMap.containsKey(current)) {
                for (Node withRandomNode : toRandomMap.get(current)) {
                    withRandomNode.random = copyCurrent;
                }
            }

            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        return copyHead;
    }
}