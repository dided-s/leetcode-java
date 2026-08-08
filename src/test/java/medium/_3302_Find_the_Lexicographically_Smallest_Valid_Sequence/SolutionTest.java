package medium._3302_Find_the_Lexicographically_Smallest_Valid_Sequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String word1, String word2, int[] expected) {
        int[] actual = new Solution().validSequence(word1, word2);

        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("vbcca", "abc", new int[]{0, 1, 2}),
                Arguments.of("bacdc", "abc", new int[]{1, 2, 4}),
                Arguments.of("aaaaaa", "aaabc", new int[]{})
        );
    }
}