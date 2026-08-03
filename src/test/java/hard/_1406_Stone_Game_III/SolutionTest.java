package hard._1406_Stone_Game_III;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] stoneValue, String expected) {
        String actual = new Solution().stoneGameIII(stoneValue);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 7}, "Bob"),
                Arguments.of(new int[]{1, 2, 3, -9}, "Alice"),
                Arguments.of(new int[]{1, 2, 3, 6}, "Tie"),
                Arguments.of(new int[]{-1, -2, -3}, "Tie")
        );
    }
}