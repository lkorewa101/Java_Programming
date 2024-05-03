package Week2;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y, z;

        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();

        if((x+y) > z && (x+z) > y && (y + z) > x) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}