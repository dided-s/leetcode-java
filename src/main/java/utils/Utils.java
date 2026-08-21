package utils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    public static void main(String[] args) {
        String stringWithSquareBrackets = "[[4,3],[1,4],[4,6],[1,7]]";
        String stringWithCurlyBrackets = stringWithSquareBrackets.replaceAll("\\[", "{")
                .replaceAll("]", "}");

        System.out.println(stringWithCurlyBrackets);
    }

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
        if (input == null || input.isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] getIntArray(String input, char delimiter) {
        return getIntArray(input, String.valueOf(delimiter));
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

    public static void printWithMarkedIndex(int[] array, int... markedIndexes) {
        printWithMarkedIndex(array, Arrays.stream(markedIndexes).boxed().collect(Collectors.toSet()), System.out);
    }

    public static void printWithMarkedIndex(int[] array, Set<Integer> markedIndexes) {
        printWithMarkedIndex(array, markedIndexes, System.out);
    }

    public static void printWithMarkedIndex(int[] array, Set<Integer> markedIndexes, PrintStream out) {
        for (int i = 0; i < array.length; i++) {
            if (markedIndexes.contains(i)) {
                out.printf("(%2d)", array[i]);
            } else out.printf(" %2d ", array[i]);
        }

        out.println();

        for (int i = 0; i < array.length; i++) {
            if (markedIndexes.contains(i)) {
                out.printf("(%2d)", i);
            } else out.printf(" %2d ", i);
        }

        out.println();
        out.println();
    }


    private Utils() {
    }
}