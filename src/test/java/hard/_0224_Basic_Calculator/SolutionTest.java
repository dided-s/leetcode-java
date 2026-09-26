package hard._0224_Basic_Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int expected) {
        int actual = new Solution().calculate(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("1 + 1", 2),
                Arguments.of(" 2-1 + 2 ", 3),
                Arguments.of("(1+(4+5+2)-3)+(6+8)", 23),
                Arguments.of("-1", -1),
                Arguments.of("-(1 + 2)", -3),
                Arguments.of("-(1 + 32)", -33)
        );
    }
}