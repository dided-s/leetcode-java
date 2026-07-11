package medium._1657_Determine_if_Two_Strings_Are_Close;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_1657_Determine_if_Two_Strings_Are_Close/data.csv", delimiter = ' ')
    void testCsv(String word1, String word2, boolean expected) {
        boolean actual = new Solution().closeStrings(word1, word2);

        Assertions.assertEquals(expected, actual);
    }
}