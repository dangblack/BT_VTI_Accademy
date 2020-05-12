package TestingSystem.Entity.Assignment5.Exercise7;

public abstract class DienThoai implements iDienThoai{
    public void nghe(){
        System.out.println("Đang nghe...");
    }
    public void goi(){
        System.out.println("Đang gọi...");

    }
    public void guiTinNhan(){
        System.out.println("Đang gửi tin nhắn...");

    }
    public void nhanTinNhan(){
        System.out.println("Đã nhận tin nhắn...");
    }
}
