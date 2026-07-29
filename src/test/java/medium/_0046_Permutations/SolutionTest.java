package medium._0046_Permutations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, Set<List<Integer>> expected) {
        Set<List<Integer>> actual = Set.copyOf(new Solution().permute(nums));

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        Set.of(
                                List.of(1, 2, 3),
                                List.of(1, 3, 2),
                                List.of(2, 1, 3),
                                List.of(2, 3, 1),
                                List.of(3, 1, 2),
                                List.of(3, 2, 1)
                        )
                ),
                Arguments.of(
                        new int[]{0, 1},
                        Set.of(
                                List.of(0, 1),
                                List.of(1, 0)
                        )
                ),
                Arguments.of(
                        new int[]{1},
                        Set.of(
                                List.of(1)
                        )
                )
        );
    }
}