package com.dominiksymonowicz.transportmanager.common;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

import static java.util.Objects.isNull;

/*
Yeah , I know utils
 */
public class Utils {
    private static final Random RANDOM = new Random(System.nanoTime());
    public static final String EMPTY_STRING = "";
    public static final String WHITESPACE = " ";
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String COMMA = ",";
    public static final String UNDERSCORE = "_";

    private static final String DEFAULT_VALUE_NAME = "Value";
    private static final int MAX_LARGE_VALUE_RANGE = 4096;
    private static final String OPEN_ARRAY = "[";
    private static final char CLOSE_ARRAY = ']';

    public static final String FIELD_SEPARATOR = ";;";


    public static void validateIfNotEmpty(String value) {
        throwExceptionIfEmpty(value, DEFAULT_VALUE_NAME);
    }

    public static void validateIfNotEmpty(String value, String name) {
        throwExceptionIfEmpty(value, name);
    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String generateString() {
        return generateString(0, RANDOM.nextInt(MAX_LARGE_VALUE_RANGE) + 1);
    }

    private static void throwExceptionIfEmpty(String object, String objectName) {
        if (object == null || object.isEmpty()) {
            throw new IllegalArgumentException(getErrorMessage(objectName));
        }
    }

    private static Character getRandomCharacterFrom(String array) {
        return array.toCharArray()[RANDOM.nextInt(ALPHABET.length())];
    }

    public static String generateString(int min, int max) {
        if (min > max || min < 0 || max <= 0) {
            throw new IllegalArgumentException("Value must be higher than zero and min value must be smaller is larger than max value");
        }
        int sizeOfString = min + RANDOM.nextInt(max - min);
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int index = 0; index <= sizeOfString; index++) {
            stringBuilder.append(getRandomCharacterFromAlphabet());
        }
        return stringBuilder.toString();
    }

    public static String printArray(String[] array) {
        final StringBuilder stringBuilder = new StringBuilder(OPEN_ARRAY);
        for (String text : array) {
            stringBuilder.append(text).append(COMMA);
        }
        stringBuilder.trimToSize();
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append(CLOSE_ARRAY);
        return stringBuilder.toString();
    }

    public static Character getRandomCharacterFromAlphabet() {
        return getRandomCharacterFrom(ALPHABET);
    }


    private static String getErrorMessage(String what) {
        return what + " cannot be null or empty.";
    }


    public static boolean notEquals(String newValue, String currentValue) {
        if (Objects.isNull(newValue) || Objects.isNull(currentValue)) {
            return false;
        }
        return !newValue.equals(currentValue);
    }


    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public static int countPercentage(int value, int total) {
        return Math.round(value * 100 / total);
    }

    public static boolean isAnyOfPropertiesContainsNull(Object... properties) {
        for (Object property : properties) {
            if (Objects.isNull(property)) {
                return true;
            }
        }
        return false;
    }
}
