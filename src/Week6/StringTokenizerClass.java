package Week6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;

        while(true) {
            s = sc.nextLine();

            if(s.equals("그만")) {
                System.out.println("종료합니다...");
                break;
            }

            StringTokenizer st = new StringTokenizer(s);
            int n = st.countTokens();
            System.out.println("어절 개수는 " + n);
        }
    }
}