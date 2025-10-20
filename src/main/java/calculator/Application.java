package calculator;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();
        Calculator calculator = new Calculator(input);
        boolean isCustom = Delimiter.isUsingCustomDelimiter(input);

        if (isCustom) {
            String delimiter = Delimiter.getCustomDelimiter(input);
            Delimiter.addCustomDelimiter(delimiter);
        }

        String[] nums = input.split(Delimiter.getDelimiter());

        int sum = Arrays.stream(nums)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .peek(n -> {
                    if (n < 0) throw new IllegalArgumentException();
                })
                .sum();

        System.out.println("결과 : " + sum);

    }
}
