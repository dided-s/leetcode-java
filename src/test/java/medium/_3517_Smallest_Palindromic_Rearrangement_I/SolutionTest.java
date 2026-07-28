package medium._3517_Smallest_Palindromic_Rearrangement_I;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, String expected) {
        String actual = new Solution().smallestPalindrome(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("z", "z"),
                Arguments.of("babab", "abbba"),
                Arguments.of("daccad", "acddca"),
                Arguments.of("yey", "yey")
        );
    }
}