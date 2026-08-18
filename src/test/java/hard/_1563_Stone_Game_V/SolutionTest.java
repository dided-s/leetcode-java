package hard._1563_Stone_Game_V;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] stoneValue, int expected) {
        int actual = new Solution().stoneGameV(stoneValue);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{6, 2, 3, 4, 5, 5}, 18),
                Arguments.of(
                        new int[]{7, 7, 7, 7, 7, 7, 7}, 28),
                Arguments.of(
                        new int[]{4}, 0)
        );
    }
}