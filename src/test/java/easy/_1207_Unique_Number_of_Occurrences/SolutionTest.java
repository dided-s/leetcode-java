package easy._1207_Unique_Number_of_Occurrences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1207_Unique_Number_of_Occurrences/data.csv", delimiter = ' ')
    void testCsv(String input, boolean expected) {
        int[] arr = Utils.getIntArray(input);
        boolean actual = new Solution().uniqueOccurrences(arr);

        Assertions.assertEquals(expected, actual);
    }
}