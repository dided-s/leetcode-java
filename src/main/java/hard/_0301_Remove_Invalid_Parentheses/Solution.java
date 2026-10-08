package hard._0301_Remove_Invalid_Parentheses;

import annotations.Hard;

import java.util.*;

@Hard
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                ans.add(current);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < current.length(); i++) {
                char ch = current.charAt(i);
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = current.substring(0, i) + current.substring(i + 1);

                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}