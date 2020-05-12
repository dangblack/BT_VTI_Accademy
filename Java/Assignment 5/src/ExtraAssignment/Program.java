package ExtraAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {
    private static final String CHAR_LIST = "1234567890";
    public static String[] db = new String[1];
    public static String[] nhat = new String[1];
    public static String[] nhi = new String[2];
    public static String[] ba = new String[6];
    public static String[] tu = new String[4];
    public static String[] nam = new String[6];
    public static String[] sau = new String[3];
    public static String[] bay = new String[4];
    public static int tien = 1000000;
    public static void main(String[] args) throws IOException {
        int chon;
        Scanner scanner = new Scanner(System.in);
        int choiTiepKhong;
        do {
            MenuMain();
            chon = scanner.nextInt();
            switch (chon){
                case 1:
                    do {
                        QuayXS();
                        ChoiLo();
                        System.out.println("Bạn có muốn chơi nữa không? (0: không // kí tự khác: tiếp)");
                        choiTiepKhong = scanner.nextInt();
                    }while (choiTiepKhong != 0);
                    break;
                case 2:
                    do {
                        QuayXS();
                        ChoiDe();
                        System.out.println("Bạn có muốn chơi nữa không? (0: không // kí tự khác: tiếp)");
                        choiTiepKhong = scanner.nextInt();
                    }while (choiTiepKhong != 0);
                    break;
                case 3:
                    do {
                        QuayXS();
                        ChoiCaLoCaDe();
                        System.out.println("Bạn có muốn chơi nữa không? (0: không // kí tự khác: tiếp)");
                        choiTiepKhong = scanner.nextInt();
                    }while (choiTiepKhong != 0);
                    break;
                case 4:
                    tien+=1000000;
                    System.out.println("Bạn đã cắm sổ đỏ thành công !");
                    System.out.println("Số tiền trong tài khoản của bạn là: " + tien);
                    break;
                case 5:
                    System.out.println("Số tiền trong tài khoản của bạn là: " + tien);
                    break;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại !");
            }
        }while (chon!=0);
    }
    public static void MenuMain(){
        System.out.println("========GAME LÔ ĐỀ HỌC==========");
        System.out.println("==============MENU==============");
        System.out.println("||  1. Chơi lô                ||");
        System.out.println("||  2. Chơi đề                ||");
        System.out.println("||  3. Quất cả lô cả đề       ||");
        System.out.println("||  4. Cắm sổ đỏ              ||");
        System.out.println("||  5. Tra tài khoản          ||");
        System.out.println("||  0. Thoát                  ||");
        System.out.println("================================");
        System.out.println("Bạn chọn:                       ");

    }
    public static void QuayXS(){
        RandomGiai(db);

        RandomGiai(nhat);

        RandomGiai(nhi);

        RandomGiai(ba);

        RandomGiai(tu);

        RandomGiai(nam);

        RandomGiai(sau);

        RandomGiai(bay);
    }
    public static void RandomGiai(String[] giai){
//        Random random = new Random();
//        for (int i = 0; i < giai.length; i++) {
//            giai[i] = String.valueOf(random.nextInt(99999));
//        }

        for (int i = 0; i < giai.length; i++){
            StringBuilder sb = new StringBuilder(5);
            for (int j = 0; j<5;j++){
                int index = (int)(CHAR_LIST.length() * Math.random());
                sb.append(CHAR_LIST.charAt(index));
            }
            giai[i] = sb.toString();
        }

    }
    public static void inGiai(String[] giai){
        for (int i = 0; i < giai.length; i++) {
            System.out.print(giai[i] + " ");
        }
        System.out.println("\n");
    }
    public static void ThongBaoGiai(){
        System.out.println("Giải đặc biệt: ");
        inGiai(db);
        System.out.println("Giải Nhất: ");
        inGiai(nhat);
        System.out.println("Giải Nhì: ");
        inGiai(nhi);
        System.out.println("Giải Ba: ");
        inGiai(ba);
        System.out.println("Giải Tư: ");
        inGiai(tu);
        System.out.println("Giải Năm: ");
        inGiai(nam);
        System.out.println("Giải Sáu: ");
        inGiai(sau);
        System.out.println("Giải Bảy: ");
        inGiai(bay);
    }
    public static void ChoiLo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String soLo;

        int tienChoi;
        if (tien <= 0){
            System.out.println("Hết tiền rồi về cắm sổ đỏ đi !");
            return;
        }

        do {
            System.out.println("Nhập con lô mà bạn muốn đánh (nhập 2 số): ");
            soLo = scanner.nextLine();
            if (checkNhapSo(soLo) == false){
                System.out.println("Vui lòng nhập vào số có 2 chữ số !");
            }
        }while (checkNhapSo(soLo) == false);
        do{
            System.out.println("Nhập số tiền mà bạn muốn chơi:");
            tienChoi = scanner.nextInt();
            scanner.nextLine();
            if (tienChoi < 0 || tienChoi>tien){
                System.out.println("Tiền ít đánh ít thôi bạn ơi !");
            }
        }while (tienChoi < 0 || tienChoi>tien);

        int tienThang = 0;

        tien -= tienChoi;
//        if(checkGiai(db,soLo)){
//            System.out.println("Bạn đã trúng giải đặc biệt ");
//        };
        ThongBaoGiai();
        int soNhay = 0;
        soNhay = TinhSoNhay(soLo);

        if (soNhay == 0){
            System.out.println("Bạn không trúng con lô nào cả !");
            System.out.println("Số tiền của bạn còn: " + tien);
        }
        else {
            System.out.println("Con lô của bạn về " + soNhay + " nháy");
            tienThang += (tienChoi/23)*80*soNhay;
            System.out.println("Bạn trúng " + tienThang + " tiền lô !");
            tien+=tienThang;
            System.out.println("Số tiền hiện tại của bạn: " + tien);
        }
    }
    public static int TinhSoNhay(String soLo){
        int soNhay = 0;
        soNhay+=checkSoNhay(db,soLo);
        soNhay+=checkSoNhay(nhat,soLo);
        soNhay+=checkSoNhay(nhi,soLo);
        soNhay+=checkSoNhay(ba,soLo);
        soNhay+=checkSoNhay(tu,soLo);
        soNhay+=checkSoNhay(nam,soLo);
        soNhay+=checkSoNhay(sau,soLo);
        soNhay+=checkSoNhay(bay,soLo);
        return soNhay;
    }
    public static void ChoiDe() throws IOException {

        Scanner scanner = new Scanner(System.in);
        String soDe;

        int tienChoi;
        if (tien <= 0){
            System.out.println("Hết tiền rồi về cắm sổ đỏ đi !");
            return;
        }
        do {
            System.out.println("Nhập con đề mà bạn muốn đánh (nhập 2 số): ");
            soDe = scanner.nextLine();
            if (checkNhapSo(soDe) == false){
                System.out.println("Vui lòng nhập vào số có 2 chữ số !");
            }
        }while (checkNhapSo(soDe) == false);

        do{
            System.out.println("Nhập số tiền mà bạn muốn chơi:");
            tienChoi = scanner.nextInt();
            scanner.nextLine();
            if (tienChoi < 0 || tienChoi>tien){
                System.out.println("Tiền ít đánh ít thôi bạn ơi");
            }
        }while (tienChoi < 0 || tienChoi>tien);
        int tienThang = 0;
        int soNhay = 0;
        tien -= tienChoi;
//        if(checkGiai(db,soLo)){
//            System.out.println("Bạn đã trúng giải đặc biệt ");
//        };
        ThongBaoGiai();
        soNhay+=checkSoNhay(db,soDe);
        if (soNhay == 0){
            System.out.println("Không trúng đề rồi bạn ơi");
            System.out.println("Số tiền của bạn còn: " + tien);
        }
        else {
            System.out.println("Bạn đã trúng đề");
            tienThang += tienChoi*70;
            System.out.println("Bạn trúng " + tienThang + " tiền lô !");
            tien+=tienThang;
            System.out.println("Số tiền hiện tại của bạn: " + tien);
        }
    }
    public static void ChoiCaLoCaDe() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String soDe, soLo;

        int tienChoiLo, tienChoiDe;
        if (tien <= 0){
            System.out.println("Hết tiền rồi về cắm sổ đỏ đi !");
            return;
        }
        do {
            System.out.println("Nhập con đề mà bạn muốn đánh (nhập 2 số): ");
            soDe = scanner.nextLine();
            if (checkNhapSo(soDe) == false){
                System.out.println("Vui lòng nhập vào số có 2 chữ số !");
            }
            System.out.println("Nhập con lô mà bạn muốn đánh (nhập 2 số): ");
            soLo = scanner.nextLine();
            if (checkNhapSo(soLo) == false){
                System.out.println("Vui lòng nhập vào số có 2 chữ số !");
            }
        }while (checkNhapSo(soDe) == false && checkNhapSo(soLo) == false);

        do{
            System.out.println("Nhập số tiền mà bạn muốn chơi lô:");
            tienChoiLo = scanner.nextInt();
            scanner.nextLine();
            if (tienChoiLo < 0 || tienChoiLo>tien){
                System.out.println("Tiền ít đánh ít thôi bạn ơi");
            }
            System.out.println("Nhập số tiền mà bạn muốn chơi đề:");
            tienChoiDe = scanner.nextInt();
            scanner.nextLine();
            if (tienChoiDe < 0 || tienChoiDe>tien){
                System.out.println("Tiền ít đánh ít thôi bạn ơi");
            }
        }while (tienChoiDe < 0 || tienChoiDe>tien && tienChoiLo < 0 || tienChoiLo>tien);
        int tienThang = 0;
        int soNhayDe = 0, soNhayLo = 0;
        tien -= tienChoiDe;
        tien -= tienChoiLo;
//        if(checkGiai(db,soLo)){
//            System.out.println("Bạn đã trúng giải đặc biệt ");
//        };
        ThongBaoGiai();
        soNhayDe+=checkSoNhay(db,soDe);
        soNhayLo = TinhSoNhay(soLo);
        if (soNhayDe == 0){
            System.out.println("Không trúng đề rồi bạn ơi");
            System.out.println("Số tiền của bạn còn: " + tien);
        }
        else {
            System.out.println("Bạn đã trúng đề");
            tienThang += tienChoiDe*70;
            System.out.println("Bạn trúng " + tienThang + " tiền lô !");
            tien+=tienThang;
            System.out.println("Số tiền hiện tại của bạn: " + tien);
        }

        if (soNhayLo == 0){
            System.out.println("Bạn không trúng con lô nào cả !");
            System.out.println("Số tiền của bạn còn: " + tien);
        }
        else {
            System.out.println("Con lô của bạn về " + soNhayLo + " nháy");
            tienThang += (tienChoiLo/23)*80*soNhayLo;
            System.out.println("Bạn trúng " + tienThang + " tiền lô !");
            tien+=tienThang;
            System.out.println("Số tiền hiện tại của bạn: " + tien);
        }
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public static boolean checkNhapSo(String input) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        if (isNumeric(input) && input.length() == 2) {
            return true;
        }
        return false;

    }
//    public static boolean checkGiai(String[] giai, int number){
//        for (int i = 0; i < giai.length; i++) {
//            int kq = Integer.parseInt(giai[i].substring(3));
//            if (number == kq){
//                return true;
//            }
//        }
//        return false;
//    }
    public static int checkSoNhay(String[] giai, String number){
        int soNhay = 0;
        String kq;
        for (int i = 0; i < giai.length; i++) {
            kq = giai[i].substring(3);
            if (number.equals(kq)){
                soNhay++;
            }
        }
        return soNhay;
    }

}
