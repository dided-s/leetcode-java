package medium._3723_Maximize_Sum_of_Squares_of_Digits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int num, int sum, String expected) {
        String actual = new Solution().maxSumOfSquares(num, sum);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(2, 3, "30"),
                Arguments.of(2, 17, "98"),
                Arguments.of(1, 10, ""),
                Arguments.of(1, 9, "9")
        );
    }
}