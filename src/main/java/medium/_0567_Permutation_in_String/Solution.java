package medium._0567_Permutation_in_String;

import annotations.Medium;
import annotations.Topic;

@Medium
@Topic("Sliding Window")
public class Solution {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int l = 0;

        for (int r = s1.length() - 1; r < s2.length(); r++) {
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;

            if (r + 1 < s2.length()) {
                freq2[s2.charAt(l) - 'a']--;
                l++;
                freq2[s2.charAt(r + 1) - 'a']++;
            }
        }

        return false;
    }
}