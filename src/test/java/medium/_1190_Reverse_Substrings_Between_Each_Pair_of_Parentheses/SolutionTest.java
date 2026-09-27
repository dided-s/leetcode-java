package medium._1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, String expected) {
        String actual = new Solution().reverseParentheses(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("(abcd)", "dcba"),
                Arguments.of("(u(love)i)", "iloveu"),
                Arguments.of("(ed(et(oc))el)", "leetcode")
        );
    }
}