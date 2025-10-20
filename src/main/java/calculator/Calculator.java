package calculator;

import java.util.Arrays;

public class Calculator {
    private final String input;
    private int sum;
    private final Delimiter delimiter;

    public Calculator(String input) {
        this.input = input;
        this.sum = 0;
        this.delimiter = new Delimiter(input);
    }

    public int calculate() {
        boolean isCustom = delimiter.isUsingCustomDelimiter();

        if (isCustom) {
            String customDelimiter = delimiter.getCustomDelimiter();
            delimiter.addCustomDelimiter(customDelimiter);
        }

        String[] nums = input.split(delimiter.getDelimiter());

        return Arrays.stream(nums)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .peek(n -> {
                    if (n < 0) throw new IllegalArgumentException();
                })
                .sum();
    }
}
