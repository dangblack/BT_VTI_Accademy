package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q12;

import java.util.Scanner;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }
    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngành đào tạo: ");
        setNganhDaoTao(scanner.nextLine());
    }
    public void hien(){
        super.hien();
        System.out.println("Ngành đào tạo  : " + getNganhDaoTao());
    }
}
