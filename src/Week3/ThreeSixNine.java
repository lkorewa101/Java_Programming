package Week3;

public class ThreeSixNine {
    public static void main(String[] args) {
        int i = 1;
        while(i < 100) {
            int count = 0;
            if((i/10==3) || (i/10)==6 || (i/10)==9)
                count++;
            if((i%10==3) || (i%10)==6 || (i%10)==9)
                count++;

            if(count == 1) {
                System.out.println(i +" jjak");
            }
            if(count == 2) {
                System.out.println(i +" jjakjjak");
            }
            i++;
        }
    }
}