package calculator;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();

        String splitRegex = "[,:]";

        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            splitRegex = input.substring(2, endIndex);
            input = input.substring(endIndex + 2);
        }

        String[] nums = input.split(splitRegex);
        
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
