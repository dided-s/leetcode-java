package easy._2409_Count_Days_Spent_Together;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob, int expected) {
        int actual = new Solution().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("08-15", "08-18", "08-16", "08-19", 3),
                Arguments.of("10-01", "10-31", "11-01", "12-31", 0),
                Arguments.of("09-01", "10-19", "06-19", "10-20", 49)
        );
    }
}