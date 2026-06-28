package easy._392_Is_Subsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_392_Is_Subsequence/data.csv", delimiter = ',')
    void testCsv(String s, String t, boolean expected) {
        var actual = new Solution().isSubsequence(s, t);

        Assertions.assertEquals(expected, actual);
    }
}