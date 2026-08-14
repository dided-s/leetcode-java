package hard._2213_Longest_Substring_of_One_Repeating_Character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, String queryCharacters, int[] queryIndices, int[] expected) {
        int[] actual = new Solution().longestRepeating(s, queryCharacters, queryIndices);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("babacc", "bcb", new int[]{1, 3, 3}, new int[]{3, 3, 4}),
                Arguments.of("abyzz", "aa", new int[]{2, 1}, new int[]{2, 3})
        );
    }
}