package medium._0050_Pow_x_n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(double x, int n, double expected) {
        double actual = new Solution().myPow(x, n);

        Assertions.assertEquals(expected, actual, 0.0001);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(2.00000, 10, 1024.00000),
                Arguments.of(2.10000, 3, 9.26100),
                Arguments.of(2.00000, -2, 0.25000)
        );
    }
}