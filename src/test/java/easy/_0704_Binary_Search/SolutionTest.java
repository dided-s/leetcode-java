package easy._0704_Binary_Search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0704_Binary_Search/data.csv", delimiter = ' ')
    void testCsv(String input, int target, int expected) {
        int[] nums = Utils.getIntArray(input);
        int actual = new Solution().search(nums, target);

        Assertions.assertEquals(expected, actual);
    }
}