package contests._0513_weekly_contest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class Q3Test {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] tasks, int[] shifts, int[] expected) {
        int[] actual = new Q3().countTasks(tasks, shifts);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{2, 3, 4}, new int[]{20, 4, 5}, new int[]{0, 2, 0}),
                Arguments.of(new int[]{4, 2}, new int[]{3, 6, 1}, new int[]{2, 0, 2}),
                Arguments.of(new int[]{1, 1, 3, 9, 10}, new int[]{8, 10, 5, 4, 2}, new int[]{2, 1, 1, 0, 3})
        );
    }
}