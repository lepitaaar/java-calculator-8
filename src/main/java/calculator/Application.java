package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();

        String[] nums = input.split(",");

        int sum = 0;

        for (String num : nums) {
            int readNum = Integer.parseInt(num);
            sum += readNum;
        }

        System.out.println("결과 : " + sum);

    }
}
