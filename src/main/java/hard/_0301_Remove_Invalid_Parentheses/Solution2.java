package hard._0301_Remove_Invalid_Parentheses;

import annotations.Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Hard
class Solution2 {

    public List<String> removeInvalidParentheses(String s) {
        Deque<Integer> leftIndexes = new ArrayDeque<>();
        Deque<Integer> rightIndexes = new ArrayDeque<>();

        List<Integer> leftReplaceIndexes = new ArrayList<>();
        List<Integer> rightReplaceIndexes = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftIndexes.push(i);
                leftReplaceIndexes.add(i);
            } else if (c == ')') {
                rightReplaceIndexes.add(i);
                if (leftIndexes.isEmpty()) {
                    rightIndexes.push(i);
                } else {
                    leftIndexes.pop();
                }
            }
        }

        System.out.println(leftIndexes);
        System.out.println(rightIndexes);

        return null;
    }
}