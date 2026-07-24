package easy._3507_Minimum_Pair_Removal_to_Sort_Array_I;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_3507_Minimum_Pair_Removal_to_Sort_Array_I/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] nums = Utils.getIntArray(input);
        var actual = new Solution().minimumPairRemoval(nums);

        Assertions.assertEquals(expected, actual);
    }
}