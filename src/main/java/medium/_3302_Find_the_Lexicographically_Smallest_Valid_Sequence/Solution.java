package medium._3302_Find_the_Lexicographically_Smallest_Valid_Sequence;

import annotations.Medium;

@Medium
public class Solution {

    public int[] validSequence(String word1, String word2) {
        if (word2 == null || word2.isEmpty()) return new int[0];

        // create suffix array
        int[] last = new int[word2.length()];

        int index1 = word1.length() - 1;
        int index2 = word2.length() - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (word1.charAt(index1) == word2.charAt(index2)) {
                last[index2] = index1;
                index2--;
            }
            index1--;
        }

        int[] answer = new int[word2.length()];
        int index = 0;

        boolean canSkip = true;
        index1 = 0;
        index2 = 0;

        while (index1 < word1.length() && index2 < word2.length()) {
            if (word1.charAt(index1) == word2.charAt(index2)) {
                answer[index] = index1;
                index++;
                index2++;
            // index1 + 1 <= last[index2 + 1] means that in last part we match other letters and we can use canSkip
            } else if (canSkip && (index2 == word2.length() - 1 || index1 + 1 <= last[index2 + 1])) {
                canSkip = false;
                answer[index] = index1;
                index++;
                index2++;
            }

            index1++;
        }

        if (index2 == word2.length()) {
            return answer;
        }

        return new int[0];
    }
}