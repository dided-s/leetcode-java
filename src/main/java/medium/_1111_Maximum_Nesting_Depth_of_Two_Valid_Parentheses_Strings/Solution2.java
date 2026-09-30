package medium._1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings;

import annotations.Medium;

import java.util.Arrays;

@Medium
class Solution2 {

    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];

        int level = 0;
        int maxLevel = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                level++;
                if (level > maxLevel) {
                    maxLevel = level;
                }
            }
            result[i] = level;
            if (seq.charAt(i) == ')') {
                level--;
            }
        }

        System.out.println(Arrays.toString(result));

        int middleLevel = maxLevel / 2;

        for (int i = 0; i < seq.length(); i++) {
            if (result[i] <= middleLevel) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }

        return result;
    }
}