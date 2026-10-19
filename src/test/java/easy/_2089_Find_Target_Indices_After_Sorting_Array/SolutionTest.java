package easy._2089_Find_Target_Indices_After_Sorting_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int target, List<Integer> expected) {
        List<Integer> actual = new Solution().targetIndices(nums, target);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 2, List.of(1, 2)),
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 3, List.of(3)),
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 5, List.of(4))
        );
    }
}