package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4;

import java.util.Scanner;

public class TaiLieu {
    private int maTaiLieu;
    static int lastMaTaiLieu = 1000;
    private String tenNXB;
    private int soBanPhatHanh;

    public int getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(int maTaiLieu) {
        this.maTaiLieu = ++lastMaTaiLieu;

    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        setMaTaiLieu(getMaTaiLieu());
        System.out.println("Mã tài liệu: " + getMaTaiLieu());
        System.out.println("Nhập tên NXB: ");
        setTenNXB(scanner.nextLine());
        System.out.println("Nhập số bản phán hành: ");
        setSoBanPhatHanh(scanner.nextInt());
    }
    public void hien(){
        System.out.println("Mã tài liệu: " + getMaTaiLieu());
        System.out.println("Tên NXB: "+ getTenNXB());
        System.out.println("Số bản phán hành: " + getSoBanPhatHanh());
    }
}
