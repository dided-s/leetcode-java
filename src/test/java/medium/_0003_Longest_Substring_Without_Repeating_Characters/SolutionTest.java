package medium._0003_Longest_Substring_Without_Repeating_Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0003_Longest_Substring_Without_Repeating_Characters/data.csv", delimiter = ' ')
    void testCsv(String s, int expected) {
        int actual = new Solution().lengthOfLongestSubstring(s);

        Assertions.assertEquals(expected, actual);
    }
}