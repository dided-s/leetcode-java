package hard._3116_Kth_Smallest_Amount_With_Single_Denomination_Combination;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] coins, int k, long expected) {
        long actual = new Solution().findKthSmallest(coins, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 9}, 3, 9),
                Arguments.of(new int[]{5, 2}, 7, 12)
        );
    }
}