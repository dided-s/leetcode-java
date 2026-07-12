package medium._0334_Increasing_Triplet_Subsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0334_Increasing_Triplet_Subsequence/data.csv", delimiter = ' ')
    void testCsv(String input, boolean expected) {
        int[] nums = Utils.getIntArray(input);
        var actual = new Solution().increasingTriplet(nums);

        Assertions.assertEquals(expected, actual);
    }
}