package easy._1768_Merge_Strings_Alternately;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1768_Merge_Strings_Alternately/data.csv", delimiter = ',')
    void testCsv(String word1, String word2, String expected) {
        var actual = new Solution().mergeAlternately(word1, word2);

        Assertions.assertEquals(expected, actual);
    }
}