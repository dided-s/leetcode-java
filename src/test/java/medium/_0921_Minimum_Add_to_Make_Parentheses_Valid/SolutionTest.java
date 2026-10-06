package medium._0921_Minimum_Add_to_Make_Parentheses_Valid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int expected) {
        int actual = new Solution().minAddToMakeValid(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("())", 1),
                Arguments.of("(((", 3),
                Arguments.of("()()", 0),
                Arguments.of("(()(()))", 0)
        );
    }
}