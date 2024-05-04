package Week7;

import java.util.*;

public class PrintBigClass {
    public static void printBig(Vector<Integer> v) {
        int max = v.get(0);
        for(int i = 1; i < v.size(); i++) {
            if(max < v.get(i)) {
                max = v.get(i);
            }
        } System.out.println("가장 큰 수는 " + max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();

        System.out.print("정수(-1이 입력될 때까지)>> ");
        while(true) {
            int n = sc.nextInt();
            if(n == -1) {
                break;
            } v.add(Integer.valueOf(n));
        }
        printBig(v);

        sc.close();
    }
}