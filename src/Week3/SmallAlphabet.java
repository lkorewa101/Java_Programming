package Week3;

import java.util.Scanner;

public class SmallAlphabet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char a = scan.next().charAt(0);

        while(a > 'z' || a < 'a') {
            System.out.println("-1");
            a = scan.next().charAt(0);
        }
        for(int i = 0; i <= a - 'a'; i++) {
            for(char j = 'a'; j <= a - i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}