package calculator;

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

        int sum = 0;

        for (String num : nums) {
            int readNum = Integer.parseInt(num);

            if (readNum < 0) {
                throw new IllegalArgumentException();
            }

            sum += readNum;
        }

        System.out.println("결과 : " + sum);

    }
}
