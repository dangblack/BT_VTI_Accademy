package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q12;

import java.util.Scanner;

public class NhanVien extends CanBo{
    private String congViec;

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập công việc: ");
        setCongViec(scanner.nextLine());
    }
    public void hien(){
        super.hien();
        System.out.println("Công việc  : " + getCongViec());
    }
}
