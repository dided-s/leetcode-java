package medium._1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length/data.csv", delimiter = ' ')
    void testCsv(String s, int k, int expected) {
        int actual = new Solution().maxVowels(s, k);

        Assertions.assertEquals(expected, actual);
    }
}