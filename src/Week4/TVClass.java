package Week41123;

public class TVClass {
    public static void main(String [] args) {
        TV myTV = new TV("LG", 2017, 32);
        myTV.show();
    }
}
class TV {
    private String brand;
    private int year;
    private int inch;

    public TV(String brand, int year, int inch) {
        this.brand = brand;
        this.year = year;
        this.inch = inch;
    }

    public void show() {
        System.out.println(brand + "에서 만든 " + year + "년형 " + inch + "인치 TV");
    }
}