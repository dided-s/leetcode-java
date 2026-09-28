package easy._1614_Maximum_Nesting_Depth_of_the_Parentheses;

import annotations.Easy;

@Easy
public class Solution {

    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else if (s.charAt(i) == ')') {
                depth--;
            }

            if (maxDepth < depth) {
                maxDepth = depth;
            }
        }

        return maxDepth;
    }
}