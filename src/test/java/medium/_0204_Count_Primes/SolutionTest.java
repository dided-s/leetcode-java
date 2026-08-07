package medium._0204_Count_Primes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int expected) {
        int actual = new Solution().countPrimes(n);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(10, 4),
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(109, 28)
        );
    }
}