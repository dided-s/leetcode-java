package medium._1679_Max_Number_of_K_Sum_Pairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_1679_Max_Number_of_K_Sum_Pairs/data.csv", delimiter = ' ')
    void testCsv(String input, int k, int expected) {
        int[] nums = Utils.getIntArray(input);
        int actual = new Solution().maxOperations(nums, k);

        Assertions.assertEquals(expected, actual);
    }
}