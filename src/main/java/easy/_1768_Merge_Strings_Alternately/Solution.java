package easy._1768_Merge_Strings_Alternately;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Array / String")
public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index = 0;
        StringBuilder answer = new StringBuilder();

        boolean flag1, flag2;

        while ((flag1 = index < word1.length()) | (flag2 = index < word2.length())) {
            if (flag1) {
                answer.append(word1.charAt(index));
            }
            if (flag2) {
                answer.append(word2.charAt(index));
            }

            index++;
        }

        return answer.toString();
    }
}