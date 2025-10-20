package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private final List<String> delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITERS));
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값은 필수 입니다.");
        }

        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            addDelimiter(input.substring(2, endIndex));
            input = input.substring(endIndex + 2);
        }

        String[] nums = input.split(getDelimiter());

        try {
            for (String num : nums) {
                int i = Integer.parseInt(num);

                addNumber(i);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void addNumber(int i) {
        numbers.add(i);
    }

    public void addDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimiter() {
        return String.join("|", delimiters);
    }

    public List<Integer> toList() {
        return numbers;
    }
}
