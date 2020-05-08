package TestingSystem.Entity.ModelEx3Q12;

import java.util.Scanner;

public class CongNhan  extends CanBo{


    private byte bac;

    public byte getBac() {
        return bac;
    }

    public void setBac(byte bac) {
        this.bac = bac;
    }

    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập bậc của công nhân: ");
        setBac(scanner.nextByte());
    }
    public void hien(){
       super.hien();
        System.out.println("Bậc  : " + getBac());
    }

}
