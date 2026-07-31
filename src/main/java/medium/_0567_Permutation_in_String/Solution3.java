package medium._0567_Permutation_in_String;

import annotations.Medium;
import annotations.Topic;

@Medium
@Topic("Sliding Window")
public class Solution3 {

    public boolean checkInclusion(String permutationString, String string) {
        if (permutationString.length() > string.length()) return false;

        // 1. create permutation string frequency map
        int[] permutationMap = new int[26];
        int[] windowMap = new int[26];
        for (int i = 0; i < permutationString.length(); i++) {
            permutationMap[permutationString.charAt(i) - 'a']++;
            windowMap[string.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for (int j = 0; j < 26; j++) {
            if (permutationMap[j] != windowMap[j]) {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        int last;
        int current;
        for (int i = permutationString.length(); i < string.length(); i++) {
            last = string.charAt(i - permutationString.length()) - 'a';
            current = string.charAt(i) - 'a';

            windowMap[last]--;
            windowMap[current]++;

            flag = true;
            for (int j = 0; j < 26; j++) {
                if (permutationMap[j] != windowMap[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }


        return false;
    }
}