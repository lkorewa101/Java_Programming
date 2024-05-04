package Week5;

import java.util.Scanner;

interface Stack {
    int length(); // 현재 스택에 저장된 개수 리턴
    int capacity(); // 스택의 전체 저장 가능한 개수 리턴
    String pop(); // 스택의 톱(top)에 저장된 문자열 리턴
    boolean push(String val); // 스택의 톱(top)에 문자열 저장
}

class StringStack implements Stack {
    private String[] stack;
    private int top;

    public StringStack(int capacity) {
        stack = new String[capacity];
        top = -1;
    }

    public int length() {
        return top + 1;
    }

    public int capacity() {
        return stack.length;
    }

    public String pop() {
        if (top == -1) return null;
        String val = stack[top];
        stack[top] = null;
        top--;
        return val;
    }

    public boolean push(String val) {
        if (top + 1 == stack.length) return false;
        top++;
        stack[top] = val;
        return true;
    }
}

class StackApp {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        scanner.nextLine(); // 숫자 입력 후 남아있는 개행문자 제거
        StringStack stack = new StringStack(capacity);

        while (true) {
            String input = scanner.nextLine();
            if ("그만".equals(input)) break;
            boolean pushSuccess = stack.push(input);
            if (!pushSuccess) {
                System.out.println("스택이 꽉 차서 푸시 불가!");
            }
        }

        System.out.print("스택에 저장된 모든 문자열 팝 :");
        while (stack.length() > 0) {
            System.out.print(" " + stack.pop());
        }
        System.out.println();
    }
}

public class StringStackClass {
    public static void main(String[] args) {
        StackApp.run();
    }
}