package medium._0316_Remove_Duplicate_Letters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0316_Remove_Duplicate_Letters/data.csv", delimiter = ' ')
    void testCsv(String s, String expected) {
        String actual = new Solution().removeDuplicateLetters(s);

        Assertions.assertEquals(expected, actual);
    }
}