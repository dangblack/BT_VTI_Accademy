package TestingSystem.Entity.ModelEx3Q12;

import TestingSystem.Entity.Gender;

import java.util.Scanner;

public class CanBo {
    private String hoten;
    private byte tuoi;
    private Gender gt;
    private String diachi;

    public CanBo() {

    }

    public CanBo(String hoten, byte tuoi, Gender gt, String diachi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gt = gt;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Byte getTuoi() {
        return tuoi;
    }

    public void setTuoi(byte tuoi) {
        this.tuoi = tuoi;
    }

    public Gender getGt() {
        return gt;
    }

    public void setGt(int gt) {
        if (gt == 0){
            this.gt = Gender.valueOf("MALE");
        }
        else if(gt == 1){
            this.gt = Gender.valueOf("FEMALE");
        }
        else {
            this.gt = Gender.valueOf("UNKNOWN");
        }
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ tên: ");
        setHoten(scanner.nextLine());
        System.out.println("Nhập tuổi: ");
        setTuoi(scanner.nextByte());
        System.out.println("Nhập giới tính (0:Nam, 1:Nữ, khác: Unknown): ");
        setGt(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        setDiachi(scanner.nextLine());
    }
    public void hien(){
        System.out.println("Họ tên      : " + getHoten());
        System.out.println("Tuổi        : " + getTuoi());
        System.out.println("Giới tính   : " + getGt());
        System.out.println("Địa chỉ     : " + getDiachi());
    }
    @Override
    public String toString() {
        return "CanBo{" +
                "hoten='" + hoten + '\'' +
                ", tuoi=" + tuoi +
                ", gt=" + gt +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
