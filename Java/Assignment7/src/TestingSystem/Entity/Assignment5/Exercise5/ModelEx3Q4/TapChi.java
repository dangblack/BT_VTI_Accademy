package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4;

import java.util.Scanner;

public class TapChi extends TaiLieu{
    private int soPhatHanh;
    private byte thangPhatHanh;

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public byte getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(byte thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }
    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phát hành: ");
        setSoPhatHanh(scanner.nextInt());
        System.out.println("Nhập tháng phát hành: ");
        setThangPhatHanh(scanner.nextByte());
    }
    public void hien(){
        super.hien();
        System.out.println("Số phát hành: " +getSoPhatHanh());
        System.out.println("Tháng phát hành: " + getThangPhatHanh());
    }
}
