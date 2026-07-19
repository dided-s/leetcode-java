package medium._0003_Longest_Substring_Without_Repeating_Characters;

import annotations.Medium;

import java.util.HashSet;
import java.util.Set;

@Medium
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxLength = 0;
        int leftIndex = 0;

        Set<Character> leftSet = new HashSet<>();

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            char c = s.charAt(rightIndex);

            if (leftSet.contains(c)) {
                while (s.charAt(leftIndex) != c) {
                    leftSet.remove(s.charAt(leftIndex));
                    leftIndex++;
                }
                leftIndex++;
            } else {
                leftSet.add(c);
            }

            if (leftSet.size() > maxLength) {
                maxLength = leftSet.size();
            }
        }

        return maxLength;
    }
}