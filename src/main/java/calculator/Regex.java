package calculator;

import java.util.regex.Pattern;

public class Regex {
    public static final String CUSTOM_DELIMITER_REGEX = "\\Q//\\E.*\\Q\\n\\E";
    public static Pattern NUMBER_REGEX = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static boolean usingCustomDelimiter(String input) {
        return NUMBER_REGEX.matcher(input).find();
    }
}
