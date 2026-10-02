package medium._0022_Generate_Parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, Set<String> expected) {
        List<String> actual = new Solution().generateParenthesis(n);

        Assertions.assertEquals(expected, Set.copyOf(actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(3, Set.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of(1, Set.of("()"))
        );
    }
}