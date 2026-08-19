package medium._1386_Cinema_Seat_Allocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int[][] reservedSeats, int expected) {
        int actual = new Solution().maxNumberOfFamilies(n, reservedSeats);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(3, new int[][]{{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}}, 4),
                Arguments.of(2, new int[][]{{2, 1}, {1, 8}, {2, 6}}, 2),
                Arguments.of(4, new int[][]{{4, 3}, {1, 4}, {4, 6}, {1, 7}}, 4));
    }
}