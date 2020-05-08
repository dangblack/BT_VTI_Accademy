package TestingSystem.Backend.Exercise3;

import TestingSystem.Entity.ModelEx3Q12.CanBo;
import TestingSystem.Entity.ModelEx3Q12.CongNhan;
import TestingSystem.Entity.ModelEx3Q12.KySu;
import TestingSystem.Entity.ModelEx3Q12.NhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class DSCB {
    ArrayList<CanBo> canBo = new ArrayList<>();
    public void nhapCanBo(){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cán bộ muốn nhập:  ");
        n = scanner.nextInt();
        byte chon;
        CanBo cb = new CanBo();
        for (int i = 0; i < n; i++) {
            System.out.println("Bạn muốn nhập cán bộ nào? (1:Công nhân || 2: Kỹ sư || 3: Nhân Viên) ");
            chon = scanner.nextByte();
            switch (chon){
                case 1:
                    cb = new CongNhan();
                    break;
                case 2:
                    cb = new KySu();
                    break;
                case 3:
                    cb = new NhanVien();
                    break;
                default:
                    System.out.println("Nhập sai !");
                    i--;
                    break;
            }
            cb.nhap();
            canBo.add(cb);
        }
    }
    public void hienCanBo(){
        for (CanBo cb: canBo) {
            cb.hien();
        }
    }
    public void timCanBo(){
        Scanner scanner = new Scanner(System.in);
        String hoTen;
        System.out.println("Nhập họ tên cần tìm: ");
        hoTen = scanner.nextLine();
        for (CanBo cb:canBo) {
            if (hoTen.equals(cb.getHoten())){
                cb.hien();
            }
        }
    }
    public void xoaCanBo(){
        Scanner scanner = new Scanner(System.in);
        String hoTen;
        System.out.println("Nhập họ tên cần xóa: ");
        hoTen = scanner.nextLine();
        for (CanBo cb:canBo) {
            if (hoTen.equals(cb.getHoten())){
                canBo.remove(cb);
            }
        }
    }
}
