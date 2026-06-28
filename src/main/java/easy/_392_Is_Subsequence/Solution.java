package easy._392_Is_Subsequence;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Two Pointers")
public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        int subsequenceIndex = 0;

        for (char ch: t.toCharArray()) {
            if (s.charAt(subsequenceIndex) == ch) {
                subsequenceIndex++;
                if (subsequenceIndex == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}