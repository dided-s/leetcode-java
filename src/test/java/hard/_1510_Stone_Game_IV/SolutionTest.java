package hard._1510_Stone_Game_IV;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, boolean expected) {
        boolean actual = new Solution().winnerSquareGame(n);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false),
                Arguments.of(4, true)
        );
    }
}