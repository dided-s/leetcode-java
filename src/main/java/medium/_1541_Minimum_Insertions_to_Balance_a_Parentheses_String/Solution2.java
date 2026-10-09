package medium._1541_Minimum_Insertions_to_Balance_a_Parentheses_String;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
public class Solution2 {

    public int minInsertions(String s) {

        s = s.replaceAll("\\)\\)", "|");
        int answer = (int) s.chars()
                .filter(ch -> ch == ')')
                .count();
        s = s.replaceAll("\\)", "|");

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    answer++;
                }
            }
        }

        answer += stack.size() * 2;

        return answer;
    }
}