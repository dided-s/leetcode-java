package medium._443_String_Compression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

import java.util.Arrays;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_443_String_Compression/data.csv", delimiter = ' ')
    void testCsv(String input, String expectedCharsInput, int expected) {
        char[] chars = Utils.getCharArray(input);
        char[] expectedChars = Utils.getCharArray(expectedCharsInput);
        int actual = new Solution().compress(chars);

        char[] actualChars = Arrays.copyOf(chars, actual);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, actual),
                () -> Assertions.assertArrayEquals(expectedChars, actualChars,
                        Utils.assertionArraysMessage(expectedChars, actualChars))
        );
    }
}