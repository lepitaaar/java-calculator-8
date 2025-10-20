package calculator;

import calculator.constant.ErrorMsg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private final List<String> delimiters = new ArrayList<>(Arrays.asList(DEFAULT_DELIMITERS));
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMsg.EMPTY_STRING.getMessage());
        }

        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            String delimiter = input.substring(2, endIndex);

            if (delimiter.isBlank()) {
                throw new IllegalArgumentException(ErrorMsg.EMPTY_DELIMITER.getMessage());
            }
            input = input.substring(endIndex + 2);
            System.out.println(input);
            if (input.matches("\\Q//\\E.*\\Q\\n\\E")) {
                throw new IllegalArgumentException(ErrorMsg.MULTIPLE_CUSTOM_DELIMITERS.getMessage());
            }

            addDelimiter(delimiter);
        }

        String[] nums = input.split(getDelimiter());

        for (String num : nums) {
            int i = Integer.parseInt(num);
            validateNumber(i);
            addNumber(i);
        }
    }

    private void validateNumber(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(ErrorMsg.NEGATIVE_NUMBER.getMessage());
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
