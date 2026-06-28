package utils;

import java.util.Arrays;

public class Utils {

    public static String assertionArraysMessage(char[] expected, char[] actual) {
        return "\nExpected: " + Arrays.toString(expected) + "\nActual:   " + Arrays.toString(actual);
    }

    public static String assertionArraysMessage(int[] expected, int[] actual) {
        return "\nExpected: " + Arrays.toString(expected) + "\nActual:   " + Arrays.toString(actual);
    }

    public static <T> String assertionArraysMessage(T[] expected, T[] actual) {
        return "\nExpected: " + Arrays.toString(expected) + "\nActual:   " + Arrays.toString(actual);
    }

    public static int[] getIntArray(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] getIntArray(String input) {
        return getIntArray(input, ",");
    }

    public static char[] getCharArray(String input, String delimiter) {
        return input.replaceAll(delimiter, "").toCharArray();
    }

    public static char[] getCharArray(String input) {
        return getCharArray(input, ",");
    }

    private Utils() {
    }
}