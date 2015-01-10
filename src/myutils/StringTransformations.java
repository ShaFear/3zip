package myutils;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class StringTransformations {
    public static String getStringFromTwoChars(char first, char second) {
        return new StringBuilder().append(first).append(second).toString();
    }
}
