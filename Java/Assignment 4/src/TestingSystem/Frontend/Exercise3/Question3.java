package TestingSystem.Frontend.Exercise3;

import TestingSystem.Backend.Exercise3.DSCB;
import TestingSystem.Backend.Exercise3.DSTL;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        DSTL dstl = new DSTL();
        byte chon;

        do {
            menu();
            Scanner sc = new Scanner(System.in);

            chon = sc.nextByte();
            switch (chon){
                case 1:
                    dstl.nhapTaiLieu();
                    break;
                case 2:
                    dstl.hienTaiLieu();
                    break;
                case 3:
                    dstl.timTaiLieu();
                    break;
                case 4:
                    dstl.xoaTaiLieu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nhập sai ! Nhập lại !");
                    break;
            }
        }while (chon != 0);


    }
    public static void menu(){
        System.out.println("=======MENU==========");
        System.out.println("==  1. Thêm tài liệu ==");
        System.out.println("==  2. Hiện tài liệu ==");
        System.out.println("==  3. Tìm tài liệu  ==");
        System.out.println("==  4. Xóa tài liệu  ==");
        System.out.println("==  0. Thoát         ==");
        System.out.println("=====================");
    }
}
