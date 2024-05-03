package Week4;

import java.util.Scanner;

public class CalculatorClass {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operation = scanner.next();

        switch(operation) {
            case "+":
                Add add = new Add();
                add.setValue(a, b);
                System.out.println(add.calculate());
                break;
            case "-":
                Sub sub = new Sub();
                sub.setValue(a, b);
                System.out.println(sub.calculate());
                break;
            case "*":
                Mul mul = new Mul();
                mul.setValue(a, b);
                System.out.println(mul.calculate());
                break;
            case "/":
                Div div = new Div();
                div.setValue(a, b);
                if (b == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    System.out.println(div.calculate());
                }
                break;
            default:
                System.out.println("해당하는 연산이 없습니다.");
                break;
        }
        scanner.close();
    }
}

class Add{
    int a, b;
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    int calculate() {
        return a + b;
    }
}

class Sub{
    int a, b;
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    int calculate() {
        return a - b;
    }
}

class Mul{
    int a, b;
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    int calculate() {
        return a * b;
    }
}

class Div{
    int a, b;
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    int calculate() {
        if (b == 0) {
            // 0으로 나누는 경우 예외 처리가 필요하지만, 여기서는 사용자가 직접 처리하도록 함
            return 0; // 실제로는 여기서 0을 반환하는 것은 적절하지 않을 수 있음
        }
        return a / b;
    }
}