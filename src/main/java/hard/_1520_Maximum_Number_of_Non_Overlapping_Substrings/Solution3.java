package hard._1520_Maximum_Number_of_Non_Overlapping_Substrings;

import annotations.Hard;

import java.util.ArrayList;
import java.util.List;

@Hard
public class Solution3 {

    public List<String> maxNumOfSubstrings(String s) {
        Integer[] firstArray = new Integer[26];
        Integer[] lastArray = new Integer[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstArray[index] == null) {
                firstArray[index] = i;
            }
            lastArray[index] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (firstArray[i] == null) continue;

            for (int j = firstArray[i]; j <= lastArray[i]; j++) {
                int currentInnerCharIndex = s.charAt(j) - 'a';
                if (firstArray[currentInnerCharIndex] == null) continue;

                // if we cannot expand out interval, we pass
                if (firstArray[i] <= firstArray[currentInnerCharIndex] &&
                        lastArray[currentInnerCharIndex] <= lastArray[i]) continue;

                // expand out interval
                firstArray[i] = Math.min(firstArray[i], firstArray[currentInnerCharIndex]);
                lastArray[i] = Math.max(lastArray[i], lastArray[currentInnerCharIndex]);
                j = firstArray[i];
            }
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (firstArray[i] == null) continue;
            intervals.add(new int[]{firstArray[i], lastArray[i]});
        }


        // Greedy find non-overlapping intervals
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                lastEnd = interval[1];
            }
        }

        return result;
    }
}