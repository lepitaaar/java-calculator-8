package calculator;

public class Calculator {
    public int calculate(Numbers numbers) {
        return numbers.toList().stream().mapToInt(i -> i).sum();
    }
}
