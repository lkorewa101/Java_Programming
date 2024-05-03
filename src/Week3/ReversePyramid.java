package Week3;

import java.util.Scanner;

public class ReversePyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        while(num < 1 || num > 18) {
            System.out.println("-1");
            num = 0;
            num = scan.nextInt();
        }

        for(int i = 0; i < num; i++) {
            for(int j = num; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}