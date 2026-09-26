package medium._1807_Evaluate_the_Bracket_Pairs_of_a_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, List<List<String>> knowledge, String expected) {
        String actual = new Solution().evaluate(s, knowledge);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        "(name)is(age)yearsold",
                        List.of(List.of("name", "bob"), List.of("age", "two")),
                        "bobistwoyearsold"),
                Arguments.of(
                        "hi(name)",
                        List.of(List.of("a", "b")),
                        "hi?"),
                Arguments.of(
                        "(a)(a)(a)aaa",
                        List.of(List.of("a", "yes")),
                        "yesyesyesaaa")
        );
    }
}