package medium._1541_Minimum_Insertions_to_Balance_a_Parentheses_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int expected) {
        int actual = new Solution().minInsertions(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("(()))", 1),
                Arguments.of("())", 0),
                Arguments.of("))())(", 3),
                Arguments.of(")))))))", 5),
                Arguments.of("(()))(()))()())))", 4)
        );
    }
}