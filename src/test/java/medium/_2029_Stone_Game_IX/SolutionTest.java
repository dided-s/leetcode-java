package medium._2029_Stone_Game_IX;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] stones, boolean expected) {
        boolean actual = new Solution().stoneGameIX(stones);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, true),
                Arguments.of(new int[]{2}, false),
                Arguments.of(new int[]{5, 1, 2, 4, 3}, false),
                Arguments.of(new int[]{3, 3}, false),
                Arguments.of(new int[]{20, 3, 20, 17, 2, 12, 15, 17, 4}, true)
        );
    }
}