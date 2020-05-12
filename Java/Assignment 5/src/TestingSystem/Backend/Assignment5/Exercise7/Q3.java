package TestingSystem.Backend.Assignment5.Exercise7;

import TestingSystem.Entity.Assignment5.Exercise7.HinhChuNhat;
import TestingSystem.Entity.Assignment5.Exercise7.HinhVuong;

public class Q3 {
    public void tinh(){
        HinhChuNhat hcn = new HinhChuNhat();
        float c = hcn.chuVi(5,7);
        System.out.println(c);

        HinhVuong hv = new HinhVuong();
        float d = hv.dienTich((float) 8.5);
        System.out.println(d);
    }
}
