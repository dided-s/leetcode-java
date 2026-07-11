package medium._1493_Longest_Subarray_of_1s_After_Deleting_One_Element;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_1493_Longest_Subarray_of_1s_After_Deleting_One_Element/data.csv", delimiter = ' ')
    void testCsv(String s, int expected) {
        int[] nums = Utils.getIntArray(s);
        int actual = new Solution().longestSubarray(nums);

        Assertions.assertEquals(expected, actual);
    }
}