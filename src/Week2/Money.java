package Week2;

import java.util.Scanner;

public class Money {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int w50000, w10000, w1000, w500, w100, w50, w10, w1;

        if(input >= 50000) {
            w50000 = input / 50000;
            input = input % 50000;

            if(w50000 > 1) {
                System.out.println(w50000 + " 50,000won bill(s)");
            } else {
                System.out.println("1 50,000won bill");
            }
        }

        if(input >= 10000) {
            w10000 = input / 10000;
            input = input % 10000;

            if(w10000 > 1) {
                System.out.println(w10000 + " 10,000won bill(s)");
            } else {
                System.out.println("1 10,000won bill");
            }
        }

        if(input >= 1000) {
            w1000 = input / 1000;
            input = input % 1000;

            if(w1000 > 1) {
                System.out.println(w1000 + " 1,000won bill(s)");
            } else {
                System.out.println("1 1,000won bill");
            }
        }

        if(input >= 500) {
            w500 = input / 500;
            input = input % 500;

            if(w500 > 1) {
                System.out.println(w500 + " 500won coin(s)");
            } else {
                System.out.println("1 500won coin");
            }
        }

        if(input >= 100) {
            w100 = input / 100;
            input = input % 100;

            if(w100 > 1) {
                System.out.println(w100 + " 100won coin(s)");
            } else {
                System.out.println("1 100won coin");
            }
        }

        if(input >= 50) {
            w50 = input / 50;
            input = input % 50;

            if(w50 > 1) {
                System.out.println(w50 + " 50won coin(s)");
            } else {
                System.out.println("1 50won coin");
            }
        }

        if(input >= 10) {
            w10 = input / 10;
            input = input % 10;

            if(w10 > 1) {
                System.out.println(w10 + " 10won coin(s)");
            } else {
                System.out.println("1 10won coin");
            }
        }

        if(input >= 1) {
            w1 = input / 1;
            input = input % 1;

            if(w1 > 1) {
                System.out.println(w1 + " 1won coin(s)");
            } else {
                System.out.println("1 1won coin");
            }
        }
    }
}