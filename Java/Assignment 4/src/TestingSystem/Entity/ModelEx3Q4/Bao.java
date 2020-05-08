package TestingSystem.Entity.ModelEx3Q4;

import java.time.LocalDate;
import java.util.Scanner;

public class Bao extends TaiLieu{
    private String ngayPhatHanh;

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày phát hành: ");
        setNgayPhatHanh(scanner.nextLine());

    }
    public void hien(){
        super.hien();
        System.out.println("Ngày phát hành: " + getNgayPhatHanh());
    }
}
