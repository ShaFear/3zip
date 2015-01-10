package myutils;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class StringTransformations {
    public static String getStringFromTwoChars(char first, char second) {
        return new StringBuilder().append(first).append(second).toString();
    }
    public static String changeIntToStringWithZeros(Integer integer, int numberOfLetters){
        int missedZeros = numberOfLetters - integer.toString().length();
        StringBuilder stringBuilder = new StringBuilder();
        for( int j=0; j<missedZeros; j++){
            stringBuilder.append("0");
        }
        return stringBuilder.append(integer.toString()).toString();
    }
}
