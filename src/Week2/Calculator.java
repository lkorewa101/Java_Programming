package Week2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);

        float op1 = s.nextFloat();
        String op = s.next();
        float op2 = s.nextFloat();

        float result = 0;

        if(op.equals("+")) {
            result = op1 + op2;
        } else if(op.equals("-")) {
            result = op1 - op2;
        } else if(op.equals("*")) {
            result = op1 * op2;
        } else if(op.equals("/")) {
            if(op2 == 0) {
                System.out.println("False");
                s.close();
                return;
            } else {
                result = op1 / op2;
            }
        }

        System.out.println(op1 + " " + op + " " + op2 + " = " + result);
        s.close();
    }
}