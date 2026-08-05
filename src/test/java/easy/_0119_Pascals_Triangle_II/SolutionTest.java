package easy._0119_Pascals_Triangle_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int rowIndex, List<Integer> expected) {
        List<Integer> actual = new Solution().getRow(rowIndex);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        4,
                        List.of(1, 4, 6, 4, 1)),
                Arguments.of(
                        0,
                        List.of(1)),
                Arguments.of(
                        3,
                        List.of(1, 3, 3, 1))
        );
    }
}