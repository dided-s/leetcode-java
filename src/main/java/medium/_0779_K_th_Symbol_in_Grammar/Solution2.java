package medium._0779_K_th_Symbol_in_Grammar;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Recursion I")
public class Solution2 {

    /**
     * N | 1  2  3  4  5  6  7  8  9
     * 1 | 0
     * 2 | 0  1
     * 3 | 0  1  1  0
     * 4 | 0  1  1  0  1  0  0  1
     * 5 | 0  1  1  0  1  0  0  1  1  0  0  1  1  0  0  1
     */
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if (k == 1) return 0;
        if (k == 2) return 1;
        if (k == 3) return 1;

        int pow = (int) Math.pow(2, n - 2);

        if (k > pow) return (kthGrammar(n, k - pow) + 1) % 2;
        return kthGrammar(n - 1, k);
    }
}