package Week7;

import java.util.*;

public class PointHashMapClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerManager manager = new CustomerManager();

        while (true) {
            String name = sc.next();
            if (name.equals("그만")) break;
            int score = sc.nextInt();

            manager.addScore(name, score);
            manager.printScores();
        }
        sc.close();
    }
}

class CustomerManager {
    private HashMap<String, Integer> hm;

    public CustomerManager() {
        this.hm = new HashMap<>();
    }

    public void addScore(String name, int score) {
        hm.put(name, hm.getOrDefault(name, 0) + score);
    }

    public void printScores() {
        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            System.out.print("(" + key + ", " + hm.get(key) + ")");
        }
        System.out.println();
    }
}