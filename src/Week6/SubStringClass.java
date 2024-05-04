package Week6;

import java.util.Scanner;

public class SubStringClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for(int i = 0; i<s.length(); i++){
            String b = s.substring(0, 1);
            String a = s.substring(1);
            s = a + b;
            System.out.println(s);
        }
    }
}