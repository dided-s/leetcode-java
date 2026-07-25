package easy._2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] nums = Utils.getIntArray(input);
        int actual = new Solution().maximumCount(nums);

        Assertions.assertEquals(expected, actual);
    }
}