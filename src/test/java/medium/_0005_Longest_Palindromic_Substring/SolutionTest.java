package medium._0005_Longest_Palindromic_Substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.Set;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, Set<String> expectedSet) {
        String actual = new Solution().longestPalindrome(s);

        Assertions.assertTrue(expectedSet.contains(actual), Utils.assertionSetContainsMessage(expectedSet, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("babad", Set.of("bab", "aba")),
                Arguments.of("cbbd", Set.of("bb")),
                Arguments.of("abbcccba", Set.of("bcccb")),
                Arguments.of("aacabdkacaa", Set.of("aca"))
        );
    }
}