package easy._0933_Number_of_Recent_Calls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] pings, int[] expected) {
        int[] actual = new int[pings.length];

        RecentCounter recentCounter = new RecentCounter();

        for (int i = 0; i < pings.length; i++) {
            actual[i] = recentCounter.ping(pings[i]);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 100, 3001, 3002},
                        new int[]{1, 2, 3, 3})
        );
    }
}