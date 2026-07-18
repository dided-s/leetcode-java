package easy._0118_Pascals_Triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int numRows, List<List<Integer>> expected) {
        List<List<Integer>> actual = new Solution().generate(numRows);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        5,
                        List.of(
                                List.of(1),
                                List.of(1, 1),
                                List.of(1, 2, 1),
                                List.of(1, 3, 3, 1),
                                List.of(1, 4, 6, 4, 1))),
                Arguments.of(
                        1,
                        List.of(
                                List.of(1)
                        )
                ));
    }
}