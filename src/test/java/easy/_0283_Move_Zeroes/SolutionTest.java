package easy._0283_Move_Zeroes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0283_Move_Zeroes/data.csv", delimiter = ' ')
    void testCsv(String input, String output) {
        int[] nums = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(output);

        new Solution().moveZeroes(nums);

        Assertions.assertArrayEquals(expected, nums,
                Utils.assertionArraysMessage(expected, nums));
    }
}