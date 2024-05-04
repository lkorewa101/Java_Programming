package Week5;

public class IPTVClass {
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}
class TV {
    private int size;
    public TV(int size) { this.size = size; }
    protected int getSize() { return size; }
}
class ColorTV extends TV{
    private int color;
    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }
    public void printProperty() {
        System.out.println(super.getSize() + "인치 " + color + "컬러");
    }
    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
}
class IPTV extends ColorTV{
    private String address;
    public IPTV(String address, int size, int color) {
        super(size, color);
        this.address = address;
    }
    public void printProperty() {
        System.out.print("나의 IPTV는 " + address + " 주소의 ");
        super.printProperty();
    }
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();
    }
}