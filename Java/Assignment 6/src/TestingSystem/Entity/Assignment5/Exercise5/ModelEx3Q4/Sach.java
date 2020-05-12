package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4;

import java.util.Scanner;

public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên tác giả: ");
        setTenTacGia(scanner.nextLine());
        System.out.println("Nhập số trang: ");
        setSoTrang(scanner.nextInt());
    }
    public void hien(){
        super.hien();
        System.out.println("Tên tác giả: " +getTenTacGia());
        System.out.println("Số trang: " +getSoTrang());
    }

}
