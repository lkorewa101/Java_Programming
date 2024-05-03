package Week3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                int n = sc.nextInt();
                int m = sc.nextInt();
                System.out.println(n*m);
                break;
            }catch(InputMismatchException e) {
                System.out.println("-1");
                sc.nextLine();
                continue;
            }
        }
        sc.close();
    }
}