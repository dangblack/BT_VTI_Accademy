package FrontEnd;


import Backend.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws IOException {

        MainApplication();
//
//        LocalDate myObj;  // Create a date object
//        String date ="29/04/2000";
//        myObj = LocalDate.parse(date);
//        System.out.println(myObj);  // Display the current date
//        Scanner scanner = new Scanner(System.in);
//
//        LocalDate localDate = LocalDate.now();//For reference
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedString = localDate.format(formatter);
//        System.out.println(formattedString);


    }
    private static boolean checkAdmin(){
        if (Session.username.equals("Admin")){
//            AdminMenu();
            return true;
        }
        else {
//            UserMenu();
            return false;
        }
    }
    private static void MainApplication() throws IOException {
        int chon;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("========GAME LÔ ĐỀ HỌC==========");
            System.out.println("==============MENU==============");
            System.out.println("||  1. Đăng nhập              ||");
            System.out.println("||  2. Đăng ký                ||");
            System.out.println("||  0. Thoát                  ||");
            System.out.println("================================");
            System.out.println("Bạn chọn:                       ");
            chon = ScannerUntils.inputInt(scanner,"Vui lòng nhập vào một số !");
            switch (chon){
                case 1:
                    SignIn signIn = new SignIn();
                    signIn.DangNhap();
                    if (checkAdmin() == true){
                        AdminMenu();
                    }
                    else {
                        UserMenu();
                    }
                    break;
                case 2:
                    SignUp signUp = new SignUp();
                    signUp.DangKy();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Chọn sai vui lòng chọn lại !");
                    break;
            }
        }while (chon!=0);
    }
    private static void UserMenu() throws IOException {
        int chon;
        int dem = 0;
        Play play = new Play();
        QuaySo qs = new QuaySo();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("========GAME LÔ ĐỀ HỌC==========");
            System.out.println("==============MENU==============");
            System.out.println("||  1. Chơi lô                ||");
            System.out.println("||  2. Chơi đề                ||");
            System.out.println("||  3. Quất cả lô cả để       ||");
            System.out.println("||  4. Kết quả lô đề từng ngày||");
            System.out.println("||  5. Soi cầu                ||");
            System.out.println("||  6. Nạp tiền               ||");
            System.out.println("||  7. Tra tài khoản          ||");
            System.out.println("||  8. Tác giả                ||");
            System.out.println("||  0. Thoát                  ||");
            System.out.println("================================");
            System.out.println("Bạn chọn:                       ");
            chon = ScannerUntils.inputInt(scanner,"Vui lòng nhập đúng số !");
            switch (chon){
                case 1:
                    dem++;
                    play.ChoiLo();
                    break;
                case 2:
                    dem++;
                    play.ChoiDe();
                    break;
                case 3:
                    dem++;
                    play.ChoiCaLoCaDe();
                    break;
                case 4:
                    play.layKQXSTheoNgay();
                    break;
                case 5:
                    play.locKQXSTheoNgay();
                    break;
                case 6:
                    play.CamSoDo();
                    break;
                case 7:
                    play.TraTaiKhoan();
                    break;
                case 8:
                    tacGia();
                    break;

                case 0:

                    break;
                default:
                    System.out.println("Chọn sai vui lòng chọn lại !");
                    break;
            }
        }while (chon!=0);
    }

    public static void AdminMenu(){
        int chon;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("========GAME LÔ ĐỀ HỌC==========");
            System.out.println("==============MENU==============");
            System.out.println("||  1. Quay sổ số hôm nay     ||");
            System.out.println("||  2. Danh sách tài khoản    ||");
            System.out.println("||  0. Thoát                  ||");
            System.out.println("================================");
            System.out.println("Bạn chọn:                       ");
            chon = scanner.nextInt();
            switch (chon){
                case 1:
                    QuaySo quaySo = new QuaySo();
                    quaySo.QuayXS();
                    quaySo.ThongBaoGiai();
                    break;
                case 2:
                    ListAccount listAccount = new ListAccount();
                    listAccount.showAllAccount();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Chọn sai vui lòng chọn lại !");
                    break;
            }
        }while (chon!=0);


    }
    public static void tacGia(){
        System.out.println("=============THÔNG TIN TÁC GIẢ===============");
        System.out.println("=||     Họ và tên: Nguyễn Hải Đăng        ||=");
        System.out.println("=||      CNTT - Đại học Mở Hà Nội         ||=");
        System.out.println("=||          fb.com/dangblack29           ||=");
        System.out.println("=||           Phone: 0825294200           ||=");
        System.out.println("=||      haidang29productions@gmail.com   ||=");
        System.out.println("=============================================");
        System.out.println("=====DONATE: Vietcombank 0301000405054=======");
        System.out.println("=============================================");
    }
}
