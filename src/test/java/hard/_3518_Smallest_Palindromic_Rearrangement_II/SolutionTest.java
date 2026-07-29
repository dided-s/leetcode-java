package hard._3518_Smallest_Palindromic_Rearrangement_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int k, String expected) {
        String actual = new Solution().smallestPalindrome(s, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("abba", 2, "baab"),
                Arguments.of("aa", 2, ""),
                Arguments.of("bacab", 1, "abcba"),
                Arguments.of("o", 1, "o"),
                Arguments.of("xxnfnxx", 3, "xxnfnxx")
        );
    }
}