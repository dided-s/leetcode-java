package utils;

import java.util.Arrays;

public class Utils {

    public static int[] getIntArray(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] getIntArray(String input) {
        return getIntArray(input, ",");
    }

    private Utils() {
    }
}