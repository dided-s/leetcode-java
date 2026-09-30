package medium._1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings;

import annotations.Medium;

@Medium
class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
            }
            result[i] = depth % 2;
            if (seq.charAt(i) == ')') {
                depth--;
            }
        }
        return result;
    }
}