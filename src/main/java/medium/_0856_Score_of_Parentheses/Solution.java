package medium._0856_Score_of_Parentheses;

import annotations.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

@Medium
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> scores = new ArrayDeque<>();
        scores.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                scores.push(0);
            } else if (c == ')') {
                int score = scores.pop();
                if (score == 0) {
                    score = 1;
                } else {
                    score *= 2;
                }
                int newScore = scores.pop() + score;
                scores.push(newScore);
            }
        }
        return scores.pop();
    }
}