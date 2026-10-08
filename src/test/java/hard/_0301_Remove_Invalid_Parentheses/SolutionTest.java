package hard._0301_Remove_Invalid_Parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, List<String> expected) {
        List<String> actual = new Solution().removeInvalidParentheses(s);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("()())()", List.of("(())()", "()()()")),
                Arguments.of("(a)())()", List.of("(a())()", "(a)()()")),
                Arguments.of(")(", List.of("")),
                Arguments.of("())))()()", List.of("()()()")),
                Arguments.of("())))", List.of("()")),
                Arguments.of("(((()", List.of("()"))
        );
    }
}