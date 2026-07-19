package medium._0209_Minimum_Size_Subarray_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0209_Minimum_Size_Subarray_Sum/data.csv", delimiter = ' ')
    void testCsv(int target, String input, int expected) {
        int[] nums = Utils.getIntArray(input);
        int actual = new Solution().minSubArrayLen(target, nums);

        Assertions.assertEquals(expected, actual);
    }
}