package Week5;

import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();

        Calc calculator = null;

        switch(operator) {
            case "+":
                calculator = new Add();
                break;
            case "-":
                calculator = new Sub();
                break;
            case "*":
                calculator = new Mul();
                break;
            case "/":
                if (b == 0) {
                    System.out.println("계산할 수 없습니다.");
                    return;
                }
                calculator = new Div();
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                return;
        }

        calculator.setValue(a, b);
        System.out.println(calculator.calculate());
    }
}

abstract class Calc {
    protected int a, b;

    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    abstract int calculate();
}

class Add extends Calc {
    int calculate() {
        return a + b;
    }
}

class Sub extends Calc {
    int calculate() {
        return a - b;
    }
}

class Mul extends Calc {
    int calculate() {
        return a * b;
    }
}

class Div extends Calc {
    int calculate() {
        return a / b;
    }
}