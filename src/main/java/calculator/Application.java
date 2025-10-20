package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();
        Numbers numbers = new Numbers(input);
        Calculator calculator = new Calculator();
        int result = calculator.calculate(numbers);

        System.out.println("결과 : " + result);

    }
}
