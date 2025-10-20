package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();
        Calculator calculator = new Calculator(input);

        int result = calculator.calculate();

        System.out.println("결과 : " + result);

    }
}
