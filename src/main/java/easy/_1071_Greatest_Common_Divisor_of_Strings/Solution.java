package easy._1071_Greatest_Common_Divisor_of_Strings;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Array / String")
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcdEuclid(str1.length(), str2.length());

        return str1.substring(0, gcd);
    }

    private static int gcdEuclid(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcdEuclid(b, a % b);
        }
    }
}