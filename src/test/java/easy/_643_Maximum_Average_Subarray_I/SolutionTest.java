package easy._643_Maximum_Average_Subarray_I;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_643_Maximum_Average_Subarray_I/data.csv", delimiter = ' ')
    void testCsv(String input, int k, double expected) {
        int[] nums = Utils.getIntArray(input);
        double actual = new Solution().findMaxAverage(nums, k);

        Assertions.assertEquals(expected, actual);
    }
}