import dev.example.lambda.Calculator;
import dev.example.lambda.Operate;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void testAdd() {
        Calculator calculator = new Calculator(10, 20);
        int result = calculator.calculate(
                new Operate() {
                    @Override
                    public int operate(int a, int b) {
                        return a + b;
                    }
                }
        );

        System.out.println(result);
    }

    @Test
    void testAddLambda() {
        Calculator calculator = new Calculator(15, 20);
        int result = calculator.calculate((a, b) -> a + b);

        System.out.println(result);
    }

    @Test
    void testAddLambda2() {
        Calculator calculator = new Calculator(10, 30);
        Operate operate = (a, b) -> a + b;
        int result = calculator.calculate(operate);

        System.out.println(result);
    }

    @Test
    void testAddLambda3() {
        Calculator calculator = new Calculator(10, 50);
        int result = calculator.calculate(Integer::sum);

        System.out.println(result);
    }

    @Test
    void testAddLambda4() {
        Calculator calculator = new Calculator(10, 50);
        int result = calculator.calculate(getOperate());

        System.out.println(result);
    }

    private Operate getOperate() {
        return Integer::sum;
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator(20, 10);
        int result = calculator.calculate((a, b) -> a - b);

        System.out.println(result);
    }
}
