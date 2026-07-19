package medium._0316_Remove_Duplicate_Letters;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
public class Solution {

    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] inAnswer = new boolean[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            while (!inAnswer[c - 'a']
                    && !stack.isEmpty()
                    && stack.peek() > c
                    && freq[stack.peek() - 'a'] > 0) {
                inAnswer[stack.pop() - 'a'] = false;
            }

            freq[c - 'a']--;

            if (!inAnswer[c - 'a']) {
                stack.push(c);
                inAnswer[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}