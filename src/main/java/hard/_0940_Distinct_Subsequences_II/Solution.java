package hard._0940_Distinct_Subsequences_II;

import annotations.Hard;
import annotations.Topic;

@Hard
@Topic("Dynamic Programming")
public class Solution {

    static final long MOD = 1_000_000_007L;

    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        // last index char appear
        Integer[] lastIndex = new Integer[26];

        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            char ch = s.charAt(i - 1);
            int charIndex = ch - 'a';

            dp[i] = (dp[i - 1] * 2) % MOD;

            if (lastIndex[charIndex] != null) {
                dp[i] = (dp[i] - dp[lastIndex[charIndex] - 1] + MOD) % MOD;
            }
            lastIndex[charIndex] = i;
        }

        // don't calculate empty string
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}