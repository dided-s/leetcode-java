package medium._1004_Max_Consecutive_Ones_III;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_1004_Max_Consecutive_Ones_III/data.csv", delimiter = ' ')
    void testCsv(String input, int k, int expected) {
        int[] nums = Utils.getIntArray(input, ',');
        int actual = Solution.longestOnes(nums, k);

        Assertions.assertEquals(expected, actual);
    }
}