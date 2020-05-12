package TestingSystem.Frontend.Assignment5.Exercise5;

import TestingSystem.Backend.Assignment5.Exercise5.DSCB;

import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {
        DSCB dscb = new DSCB();
        menu();
        byte chon;

        do {
            Scanner sc = new Scanner(System.in);
            menu();
            chon = sc.nextByte();
            switch (chon){
                case 1:
                    dscb.nhapCanBo();
                    break;
                case 2:
                    dscb.hienCanBo();
                    break;
                case 3:
                    dscb.timCanBo();
                    break;
                case 4:
                    dscb.xoaCanBo();
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
        System.out.println("==  1. Thêm cán bộ ==");
        System.out.println("==  2. Hiện cán bộ ==");
        System.out.println("==  3. Tìm cán bộ  ==");
        System.out.println("==  4. Xóa cán bộ  ==");
        System.out.println("==  0. Thoát       ==");
        System.out.println("=====================");
    }
}
