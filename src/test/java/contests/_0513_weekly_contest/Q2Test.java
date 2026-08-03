package contests._0513_weekly_contest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Q2Test {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int a, int b, int expected) {
        int actual = new Q2().countRatioSubarrays(nums, a, b);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2}, 3, 2, 7),
                Arguments.of(new int[]{2, 2, 1}, 2, 1, 3),
                Arguments.of(new int[]{2, 2, 2}, 1, 1, 0),
                Arguments.of(new int[]{305}, 454, 127, 1),
                Arguments.of(new int[]{359, 918}, 901, 307, 2)
        );
    }
}