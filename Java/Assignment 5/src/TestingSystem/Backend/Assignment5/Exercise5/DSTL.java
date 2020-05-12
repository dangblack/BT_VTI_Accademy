package TestingSystem.Backend.Assignment5.Exercise5;
import TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4.Bao;
import TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4.Sach;
import TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4.TaiLieu;
import TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q4.TapChi;

import java.util.ArrayList;
import java.util.Scanner;

public class DSTL {
    ArrayList<TaiLieu> taiLieu = new ArrayList<>();
    public void nhapTaiLieu(){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tài liệu mà bạn muốn nhập:  ");
        n = scanner.nextInt();
        byte chon;
        TaiLieu tl = new TaiLieu();
        for (int i = 0; i < n; i++) {
            System.out.println("Bạn muốn nhập tài liệu nào? (1:Sách || 2: Tạp chí || 3: Báo) ");
            chon = scanner.nextByte();
            switch (chon){
                case 1:
                    tl = new Sach();
                    break;
                case 2:
                    tl = new TapChi();
                    break;
                case 3:
                    tl = new Bao();
                    break;
                default:
                    System.out.println("Nhập sai !");
                    i--;
                    break;
            }
            tl.nhap();
            taiLieu.add(tl);
        }
    }
    public void hienTaiLieu(){
        for (TaiLieu tl: taiLieu) {
            tl.hien();
        }
    }
    public void timTaiLieu(){
        Scanner scanner = new Scanner(System.in);
        int chon;
        System.out.println("Bạn muốn tìm kiếm theo loại nào? (1:Sách || 2: Tạp chí || 3: Báo)");
        chon = scanner.nextByte();
        switch (chon){
            case 1:
                for (TaiLieu tl: taiLieu) {
                    if (tl instanceof Sach){
                        tl.hien();
                    }
                }
                break;
            case 2:
                for (TaiLieu tl: taiLieu) {
                    if (tl instanceof TapChi){
                        tl.hien();
                    }
                }
                break;
            case 3:
                for (TaiLieu tl: taiLieu) {
                    if (tl instanceof Bao){
                        tl.hien();
                    }
                }
                break;
            default:
                System.out.println("Nhập sai !");
                break;
        }

    }
    public void xoaTaiLieu(){
        Scanner scanner = new Scanner(System.in);
        int maTL;
        System.out.println("Nhập mã tài liệu cần xóa: ");
        maTL = scanner.nextInt();
        for (TaiLieu tl: taiLieu ) {
            if (maTL == tl.getMaTaiLieu()){
                taiLieu.remove(tl);
            }
        }
    }
}
