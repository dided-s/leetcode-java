package hard._1520_Maximum_Number_of_Non_Overlapping_Substrings;

import annotations.Hard;

import java.util.ArrayList;
import java.util.List;

@Hard
public class Solution2 {

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

        //for (int i = 0; i < 26; i++) {
        //    System.out.println("Char: " + ((char) (i + 'a')) + " firstArray: " + firstArray[i] + " lastArray: " + lastArray[i]);
        //}

        for (int i = 0; i < 26; i++) {
            if (firstArray[i] == null) continue;
            int newFirstIndex = firstArray[i];
            int newLastIndex = lastArray[i];

            for (int j = firstArray[i]; j <= lastArray[i]; j++) {
                int index = s.charAt(j) - 'a';
                if (firstArray[index] == null) continue;

                int firstIndex = firstArray[index];
                int lastIndex = lastArray[index];

                if (firstIndex < newFirstIndex) {
                    newFirstIndex = firstIndex;
                }

                if (lastIndex > newLastIndex) {
                    newLastIndex = lastIndex;
                }
            }

            firstArray[i] = newFirstIndex;
            lastArray[i] = newLastIndex;
        }

        for (int i = 0; i < 26; i++) {
            if (firstArray[i] == null) continue;
            int newFirstIndex = firstArray[i];
            int newLastIndex = lastArray[i];

            for (int j = firstArray[i]; j <= lastArray[i]; j++) {
                int index = s.charAt(j) - 'a';
                if (firstArray[index] == null) continue;

                int firstIndex = firstArray[index];
                int lastIndex = lastArray[index];

                if (firstIndex < newFirstIndex) {
                    newFirstIndex = firstIndex;
                }

                if (lastIndex > newLastIndex) {
                    newLastIndex = lastIndex;
                }
            }

            firstArray[i] = newFirstIndex;
            lastArray[i] = newLastIndex;
        }


        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (firstArray[i] == null) continue;
            intervals.add(new int[]{firstArray[i], lastArray[i]});
        }

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        //intervals.forEach(interval -> System.out.println(Arrays.toString(interval)));

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