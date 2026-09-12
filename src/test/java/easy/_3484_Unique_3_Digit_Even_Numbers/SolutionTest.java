package easy._3484_Unique_3_Digit_Even_Numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] digits, int expected) {
        int actual = new Solution().totalNumbers(digits);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 12),
                Arguments.of(new int[]{0, 2, 2}, 2),
                Arguments.of(new int[]{6, 6, 6}, 1),
                Arguments.of(new int[]{1, 3, 5}, 0),
                Arguments.of(new int[]{0, 6, 0}, 1),
                Arguments.of(new int[]{0, 5, 6, 6, 7}, 16)
        );
    }
}