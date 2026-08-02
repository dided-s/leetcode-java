package medium._0877_Stone_Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] piles, boolean expected) {
        boolean actual = new Solution().stoneGame(piles);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{5, 3, 4, 5}, true),
                Arguments.of(new int[]{3, 7, 2, 3}, true)
        );
    }
}