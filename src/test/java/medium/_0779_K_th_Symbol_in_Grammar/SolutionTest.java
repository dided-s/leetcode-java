package medium._0779_K_th_Symbol_in_Grammar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int k, int expected) {
        int actual = new Solution().kthGrammar(n, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(2, 1, 0),
                Arguments.of(2, 2, 1),
                Arguments.of(3, 4, 0)
        );
    }
}