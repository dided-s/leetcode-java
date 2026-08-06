package medium._0779_K_th_Symbol_in_Grammar;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Recursion I")
public class Solution {

    /**
     * N | 1  2  3  4  5  6  7  8  9
     * 1 | 0
     * 2 | 0  1
     * 3 | 0  1  1  0
     * 4 | 0  1  1  0  1  0  0  1
     * 5 | 0  1  1  0  1  0  0  1  1  0  0  1  1  0  0  1
     */
    public int kthGrammar(int n, int k) {
        return kthGrammar(n, k, 0);
    }

    public int kthGrammar(int n, int k, int answer) {
        if (n == 1) {
            return answer % 2 == 0 ? 0 : 1;
        }
        if (k % 2 == 0) {
            return kthGrammar(n - 1, k / 2, answer + 1);
        }
        return kthGrammar(n - 1, (k + 1) / 2, answer);
    }
}