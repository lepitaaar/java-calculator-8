package calculator;

import java.util.Arrays;
import java.util.List;

public class Delimiter {
    static List<String> delimiters = Arrays.asList(",", ":");

    public static boolean isUsingCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    public static String getCustomDelimiter(String input) {
        int endIndex = input.indexOf("\\n");
        return input.substring(2, endIndex);
    }

    public static void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public static String getDelimiter() {
        return String.join("|", delimiters);
    }
}
