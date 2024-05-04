package Week6;

public class CircleClass {
    public static void main(String[] args) {
        Circle a = new Circle(2, 3, 5);
        Circle b = new Circle(2, 3, 20);
        System.out.println("원 a : " + a);
        System.out.println("원 b : " + b);
        if(a.equals(b)) System.out.println("같은 원");
        else System.out.println("서로 다른 원");
    }
}

class Circle {
    private int x, y, radius;
    public Circle(int x, int y, int radius) {
        this.x=x; this.y=y; this.radius=radius;
    }
    public String toString() {
        return "Circle(" + x + "," + y + ")반지름" + radius;
    }
    public boolean equals(Object obj) {
        Circle c = (Circle) obj;
        if(x == c.x && y == c.y) return true;
        else return false;
    }
}