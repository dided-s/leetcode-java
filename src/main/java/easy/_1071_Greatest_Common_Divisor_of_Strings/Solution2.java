package easy._1071_Greatest_Common_Divisor_of_Strings;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Array / String")
public class Solution2 {
    public String gcdOfStrings(String bigString, String smallString) {
        int bigStringLength = bigString.length();
        int smallStringLength = smallString.length();

        if (bigStringLength < smallStringLength) {
            return gcdOfStrings(smallString, bigString);
        }

        String answer = "";

        for (int cd = 1; cd * cd <= smallStringLength; cd++) {
            String cdString = smallString.substring(0, smallStringLength / cd);

            if (isCd(smallString, cdString) && isCd(bigString, cdString)) {
                return cdString;
            }

            cdString = smallString.substring(0, cd);

            if (isCd(smallString, cdString) && isCd(bigString, cdString)) {
                answer = cdString;
            }
        }

        return answer;
    }

    private boolean isCd(String bigString, String smallString) {
        int bigStringLength = bigString.length();
        int smallStringLength = smallString.length();

        if (bigStringLength < smallStringLength) {
            return false;
        }
        if (bigStringLength % smallStringLength != 0) {
            return false;
        }

        return smallString.repeat(bigStringLength / smallStringLength).equals(bigString);
    }
}