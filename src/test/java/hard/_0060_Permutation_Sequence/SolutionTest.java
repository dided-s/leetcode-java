package hard._0060_Permutation_Sequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int k, String expected) {
        String actual = new Solution().getPermutation(n, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(3, 3, "213"),
                Arguments.of(4, 9, "2314"),
                Arguments.of(3, 1, "123"),
                Arguments.of(7, 25, "1243567"),
                Arguments.of(7, 49, "1253467")
        );
    }
}