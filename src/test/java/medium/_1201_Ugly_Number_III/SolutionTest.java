package medium._1201_Ugly_Number_III;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int a, int b, int c, int expected) {
        int actual = new Solution().nthUglyNumber(n, a, b, c);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(3, 2, 3, 5, 4),
                Arguments.of(4, 2, 3, 4, 6),
                Arguments.of(5, 2, 11, 13, 10),
                Arguments.of(6, 2, 1, 3, 6),
                Arguments.of(1000000000, 2, 217983653, 336916467, 1999999984),
                Arguments.of(5, 2, 3, 3, 8)
        );
    }
}