package medium._0022_Generate_Parentheses;

import annotations.Medium;

import java.util.ArrayList;
import java.util.List;

@Medium
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, n, n, "");

        return result;
    }

    private void helper(List<String> list, int leftCount, int rightCount, String s) {
        if (leftCount == 0 && rightCount == 0) {
            list.add(s);
        }

        if (rightCount < leftCount) return;
        if (leftCount > 0) helper(list, leftCount - 1, rightCount, s + "(");
        if (rightCount > 0) helper(list, leftCount, rightCount - 1, s + ")");
    }
}