package hard._3518_Smallest_Palindromic_Rearrangement_II;

import annotations.Hard;
import annotations.Topic;

@Hard
@Topic("Combinatorics")
public class Solution {

    public String smallestPalindrome(String s, long k) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 'a'] += 1;
        }
        String middle = (s.length() % 2 == 0) ? "" : String.valueOf(s.charAt(s.length() / 2));

        StringBuilder left = new StringBuilder();
        long startIndex = 1;

        for (int pos = 0; pos < partition; pos++) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] == 0) {
                    continue;
                }

                bucket[i] -= 1;

                long ways = permutationsCount(partition - pos - 1, bucket, k);
                if (startIndex + ways > k) {
                    left.append((char) (i + 97));
                    break;
                }

                bucket[i] += 1;
                startIndex += ways;
            }
        }

        if (left.length() < partition) {
            return "";
        }

        return left + middle + left.reverse();
    }

    // C(n, m). if > k we can return k.\
    // n!/m!(n-m)!
    private long combinations(long n, long m, long k) {
        long comb = 1;
        m = Math.min(m, n - m);

        for (long i = 1; i <= m; i++) {
            comb = (comb * (n - i + 1)) / i;
            if (comb > k) {
                return k + 1;
            }
        }
        return comb;
    }

    private long permutationsCount(int rem, int[] bucket, long k) {
        long ways = 1;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) {
                continue;
            }

            ways *= combinations(rem, bucket[i], k);
            if (ways > k) {
                break;
            }
            rem -= bucket[i];
        }
        return ways;
    }
}