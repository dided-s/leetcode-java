package hard._0023_Merge_k_Sorted_Lists;

import annotations.Explore;
import annotations.Hard;
import utils.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

@Hard
@Explore("Linked List")
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode head = new ListNode(0);
        ListNode current = head;

        Queue<ListNode> priorityQueue = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            current.next = node;

            current = current.next;

            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }

        return head.next;
    }
}