package Week5;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Km2Mile toDollor = new Km2Mile(1.6);
        toDollor.run();
    }
}

abstract class Converter {
    abstract protected double convert(double src);
    abstract protected String getSrcString();
    abstract protected String getDestString();
    protected double ratio;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        double val = scanner.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과: " + res + getDestString() + "입니다.");
        scanner.close();
    }
}

class Km2Mile extends Converter {
    private double oneMile;
    public Km2Mile(double oneMile) {
        this.oneMile = oneMile;
    }
    protected double convert(double src) {return src / oneMile;}
    protected String getSrcString() {return "Km";}
    protected String getDestString() {return "Mile";}


}