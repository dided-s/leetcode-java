package medium._3789_Minimum_Cost_to_Acquire_Required_Items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int cost1, int cost2, int costBoth, int need1, int need2, long expected) {
        long actual = new Solution().minimumCost(cost1, cost2, costBoth, need1, need2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(3, 2, 1, 3, 2, 3),
                Arguments.of(5, 4, 15, 2, 3, 22),
                Arguments.of(5, 4, 15, 0, 0, 0),
                Arguments.of(54, 41, 67, 3, 10, 488)
        );
    }
}