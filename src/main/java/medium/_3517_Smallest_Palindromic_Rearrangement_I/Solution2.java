package medium._3517_Smallest_Palindromic_Rearrangement_I;

import annotations.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@Medium
public class Solution2 {

    public String smallestPalindrome(String s) {
        Queue<Character> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < s.length() / 2; i++) {
            queue.add(s.charAt(i));
        }
        int length = queue.size();

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        if (s.length() % 2 == 1) {
            sb.append(s.charAt(s.length() / 2));
        }

        for (int i = length - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }

        return sb.toString();
    }
}