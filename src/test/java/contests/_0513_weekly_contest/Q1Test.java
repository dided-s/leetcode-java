package contests._0513_weekly_contest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Q1Test {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, long expected) {
        long actual = new Q1().maxPairStrength(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{2, 3, 5}, 15),
                Arguments.of(new int[]{4, 6, 8}, 12),
                Arguments.of(new int[]{3, 3}, 1)
        );
    }
}