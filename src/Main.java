import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String course [] = {"Java", "C++", "HTML5", "ComputerStructure", "Android"};
        int score [] = {95, 88, 76, 62, 55};
        int count = 0;
        while (true) {
            String name = scan.nextLine();
            if(name.equals("-1"))
                break;

            for(int i = 0; i < course.length; i++) {
                if(course[i].equals(name)) {
                    System.out.println(course[i] + " : "+ score[i]);
                    count++;
                }
            }

            if(count == 0)
                System.out.println("N/A");

        }

        scan.close();
    }
}
