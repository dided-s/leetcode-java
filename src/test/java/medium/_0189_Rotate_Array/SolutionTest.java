package medium._0189_Rotate_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0189_Rotate_Array/data.csv", delimiter = ' ')
    void testCsv(String input, int k, String output) {
        int[] nums = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(output);

        new Solution().rotate(nums, k);

        Assertions.assertArrayEquals(expected, nums, Utils.assertionArraysMessage(expected, nums));
    }
}