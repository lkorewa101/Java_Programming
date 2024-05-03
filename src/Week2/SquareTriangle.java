package Week2;

import java.util.Scanner;

public class SquareTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if(result(x1, y1, 100, 100, 200, 200) == true) {
            System.out.println("True");
        }

        else if(result(x1, y2, 100, 100, 200, 200) == true) {
            System.out.println("True");
        }

        else if(result(x2, y1, 100, 100, 200, 200) == true) {
            System.out.println("True");
        }

        else if(result(x2, y2, 100, 100, 200, 200) == true) {
            System.out.println("True");
        }

        else if(x1 <= 100 && y1 <= 100 && x2 >= 200 && y2 >= 200) {
            System.out.println("True");
        }

        else {
            System.out.println("False");
        }
    }

    public static boolean result(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {
        if((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2)) {
            return true;
        }
        else {
            return false;
        }
    }
}