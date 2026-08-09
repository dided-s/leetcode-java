package medium._1140_Stone_Game_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] piles, int expected) {
        int actual = new Solution().stoneGameII(piles);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{2, 7, 9, 4, 4},
                        10),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 100}, 104),
                Arguments.of(
                        new int[]{8270, 7145, 575, 5156, 5126, 2905, 8793, 7817, 5532, 5726, 7071, 7730, 5200, 5369, 5763, 7148, 8287, 9449, 7567, 4850, 1385, 2135, 1737, 9511, 8065, 7063, 8023, 7729, 7084, 8407},
                        98008
                ));
    }
}