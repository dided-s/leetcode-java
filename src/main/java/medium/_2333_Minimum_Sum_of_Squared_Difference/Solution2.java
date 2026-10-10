package medium._2333_Minimum_Sum_of_Squared_Difference;

import annotations.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@Medium
public class Solution2 {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        Queue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums1.length; i++) {
            maxHeap.add(Math.abs(nums1[i] - nums2[i]));
        }

        int k = k1 + k2;
        while (k > 0) {
            int top = maxHeap.poll();
            if (top == 0) return 0;
            top--;
            maxHeap.add(top);
            k--;
        }

        long answer = 0;
        while (!maxHeap.isEmpty()) {
            answer += ((long) maxHeap.peek()) * maxHeap.poll();
        }

        return answer;
    }
}