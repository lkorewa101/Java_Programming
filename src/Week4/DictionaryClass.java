package Week4;

import java.util.Scanner;

public class DictionaryClass {
    public static void main(String [] arg) {
        Scanner scanner = new Scanner(System.in);
        DicApp dicApp = new DicApp();

        System.out.println("한영 단어 검색 프로그램입니다.");
        while(true) {
            String korWord = scanner.nextLine();

            if(korWord.equals("그만")) break;

            System.out.println(korWord + " : " + Dictionary.kor2Eng(korWord));
        }
        scanner.close();
    }
}

class Dictionary {
    private static String [] kor = {"사랑", "아기", "돈", "미래", "희망" };
    private static String [] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        for(int i = 0; i < kor.length; i++) {
            if(kor[i].equals(word)) {
                return eng[i];
            }
        }
        return "저의 사전에 없습니다.";
    }
}

class DicApp{
}
