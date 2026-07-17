package easy._0088_Merge_Sorted_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0088_Merge_Sorted_Array/data.csv", delimiter = ';')
    void testCsv(String input1, int m, String input2, int n, String output) {
        int[] nums1 = Utils.getIntArray(input1);
        int[] nums2 = Utils.getIntArray(input2);

        int[] expected = Utils.getIntArray(output);

        new Solution().merge(nums1, m, nums2, n);

        Assertions.assertArrayEquals(expected, nums1, Utils.assertionArraysMessage(expected, nums1));
    }
}