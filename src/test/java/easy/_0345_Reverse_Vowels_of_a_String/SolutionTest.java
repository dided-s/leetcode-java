package easy._0345_Reverse_Vowels_of_a_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0345_Reverse_Vowels_of_a_String/data.csv", delimiter = ' ')
    void testCsv(String str, String expected) {
        var actual = new Solution().reverseVowels(str);

        Assertions.assertEquals(expected, actual);
    }
}