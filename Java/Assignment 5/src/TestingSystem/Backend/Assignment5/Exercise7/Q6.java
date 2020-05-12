package TestingSystem.Backend.Assignment5.Exercise7;

import TestingSystem.Entity.Assignment5.Exercise7.DienThoaiDiDong;
import TestingSystem.Entity.Assignment5.Exercise7.DienThoaiThongMinh;

public class Q6 {
    public void hienDTDD(){
        System.out.println("Điện thoại di động ");
        DienThoaiDiDong dienThoaiDiDong = new DienThoaiDiDong();
        dienThoaiDiDong.nghe();
        dienThoaiDiDong.goi();
        dienThoaiDiDong.guiTinNhan();
        dienThoaiDiDong.nhanTinNhan();
        dienThoaiDiDong.tanCong();
    }
    public void hienDTTM(){
        System.out.println("Điện thoại thông minh ");
        DienThoaiThongMinh dienThoaiThongMinh = new DienThoaiThongMinh();
        dienThoaiThongMinh.nghe();
        dienThoaiThongMinh.goi();
        dienThoaiThongMinh.guiTinNhan();
        dienThoaiThongMinh.nhanTinNhan();
        dienThoaiThongMinh.tanCong();
    }
}
