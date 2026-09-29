package hard._2267_Check_if_There_Is_a_Valid_Parentheses_String_Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(char[][] grid, boolean expected) {
        boolean actual = new Solution().hasValidPath(grid);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new char[][]{{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}},
                        true),
                Arguments.of(
                        new char[][]{{')', ')'}, {'(', '('}},
                        false)
        );
    }
}