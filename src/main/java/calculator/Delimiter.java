package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {
    private List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
    private String input;

    public Delimiter(String input) {
        this.input = input;
    }

    public boolean isUsingCustomDelimiter() {
        return input.startsWith("//");
    }

    public String getCustomDelimiter() {
        int endIndex = input.indexOf("\\n");
        input = input.substring(endIndex + 2);
        return input.substring(2, endIndex);
    }

    public void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimiter() {
        return String.join("|", delimiters);
    }
}
