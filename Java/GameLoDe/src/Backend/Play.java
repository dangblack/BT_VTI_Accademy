package Backend;

import Entity.Account;
import Entity.XoSo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    private final String path = "..\\GameLoDe\\src\\App_Data\\XoSo.txt";
    private final String pathAccount = "..\\GameLoDe\\src\\App_Data\\Account.txt";

    public static XoSo xoSo;
    public Account account = Session.account;
    int tien = Session.account.getTien();

    public static QuaySo qs;
    ArrayList<XoSo> arr_XoSo;

    public Play() {
        try{
            arr_XoSo = (ArrayList<XoSo>) XuLyFile.readFile(path);
        }catch (Exception e){
            arr_XoSo = new ArrayList<XoSo>();
        }
        if (arr_XoSo == null){
            arr_XoSo = new ArrayList<XoSo>();

        }
        if (arr_XoSo.size() == 0){
            System.out.println("Chưa có dữ liệu xổ số !");
            System.exit(0);
        }
        else {
            long millis=System.currentTimeMillis();
            Date date=new Date(millis);
            LocalDate today = LocalDate.parse(String.valueOf(date));

            xoSo = arr_XoSo.get(arr_XoSo.size() - 1);
            if (!xoSo.getNgayChoi().equals(today)){
                System.out.println("Hôm nay số chưa về !");
                System.exit(0);
            }

        }


    }
    public void TraTaiKhoan(){
        System.out.println("Số tiền trong tài khoản của bạn là: " + tien);
    }

    public void CamSoDo(){
        if (checkCamSoDo() == true){
            tien+=1000000;
            System.out.println("Bạn đã cắm sổ đỏ thành công !");
            System.out.println("Số tiền trong tài khoản của bạn là: " + tien);
            account.setTien(tien);
            updateAccount();
        }else {
            System.out.println("Không cắm sổ đỏ thì nghỉ chơi đi bạn !");
        }

    }
    public boolean checkCamSoDo(){
        Scanner scanner = new Scanner(System.in);
        int chon;
        System.out.println("Bạn có chắc muốn cắm sổ đỏ không? (0:không/1: có)");
        do {
            chon = ScannerUntils.inputInt(scanner,"Nhập sai, vui lòng nhập lại !");
            if (chon != 1 && chon !=0){
                System.out.println("Nhập sai, vui lòng nhập lại !");

            }
            else if (chon == 1){
                return true;
            }
        }while (chon != 1 && chon !=0);
        return false;
    }
    public void ChoiLo() throws IOException {
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
        ThongBaoGiai(xoSo);


//        qs.ThongBaoGiai();

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
        account.setTien(tien);
        updateAccount();
    }

    public void ChoiDe() throws IOException {

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
        qs.ThongBaoGiai();
        soNhay+=checkSoNhay(xoSo.getDb(),soDe);
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
        account.setTien(tien);
        updateAccount();
    }


    public int TinhSoNhay(String soLo){
        int soNhay = 0;
        soNhay+=checkSoNhay(xoSo.getDb(),soLo);
        soNhay+=checkSoNhay(xoSo.getNhat(),soLo);
        soNhay+=checkSoNhay(xoSo.getNhi(),soLo);
        soNhay+=checkSoNhay(xoSo.getBa(),soLo);
        soNhay+=checkSoNhay(xoSo.getTu(),soLo);
        soNhay+=checkSoNhay(xoSo.getNam(),soLo);
        soNhay+=checkSoNhay(xoSo.getSau(),soLo);
        soNhay+=checkSoNhay(xoSo.getBay(),soLo);
        return soNhay;
    }
    public int checkSoNhay(String[] giai, String number){
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
    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public boolean checkNhapSo(String input) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        if (isNumeric(input) && input.length() == 2) {
            return true;
        }
        return false;

    }
    public void ChoiCaLoCaDe() throws IOException {
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
        ThongBaoGiai(xoSo);

//        qs.ThongBaoGiai();

        soNhayDe+=checkSoNhay(xoSo.getDb(),soDe);
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
        account.setTien(tien);
        updateAccount();
    }
    private void ThongBaoGiai(XoSo xoSo){
        System.out.println("=======XỔ SỐ========");
        System.out.println(xoSo.getNgayChoi());
        System.out.println("Giải đặc biệt: ");
        inGiai(xoSo.getDb());
        System.out.println("Giải Nhất: ");
        inGiai(xoSo.getNhat());
        System.out.println("Giải Nhì: ");
        inGiai(xoSo.getNhi());
        System.out.println("Giải Ba: ");
        inGiai(xoSo.getBa());
        System.out.println("Giải Tư: ");
        inGiai(xoSo.getTu());
        System.out.println("Giải Năm: ");
        inGiai(xoSo.getNam());
        System.out.println("Giải Sáu: ");
        inGiai(xoSo.getSau());
        System.out.println("Giải Bảy: ");
        inGiai(xoSo.getBay());
    }
    public void inGiai(String[] giai){
        for (int i = 0; i < giai.length; i++) {
            System.out.print(giai[i] + " ");
        }
        System.out.println("\n");
    }
    public void updateAccount(){
        ArrayList<Account> accountArrayList = (ArrayList<Account>) XuLyFile.readFile(pathAccount);
        for (int i = 0; i < accountArrayList.size(); i++) {
            if (accountArrayList.get(i).getUsername().equals(account.getUsername())){
                accountArrayList.set(i,account);
                XuLyFile.writeFile(accountArrayList,pathAccount);
                break;
            }
        }
    }
    public void layKQXSTheoNgay(){
        Scanner scanner = new Scanner(System.in);
        LocalDate tg;
        System.out.println("Nhập ngày cần tìm (Vui lòng nhâp đúng định dạng yyyy-MM-dd): ");
        while (true){
            tg = ScannerUntils.inputLocalDate(scanner,"Ngày nhập vào không đúng định dạng hoặc nhập sai !");
            if (!checkToday(tg)){
                System.out.println("Ngày nhập vào phải nhỏ hơn ngày hiện tại !");
            }
            else {
                break;
            }
        }


        for (int i = 0; i < arr_XoSo.size(); i++) {
            if (arr_XoSo.get(i).getNgayChoi().equals(tg)){
                ThongBaoGiai(arr_XoSo.get(i));
            }
        }
    }
    public void locKQXSTheoNgay(){
        Scanner scanner = new Scanner(System.in);
        LocalDate tg1, tg2;
        do {
            System.out.println("Từ ngày (vui lòng nhập đúng định dạng yyyy-MM-dd): ");
            tg1 = ScannerUntils.inputLocalDate(scanner,"Ngày nhập vào không đúng định dạng hoặc nhập sai !");
            System.out.println("Đến ngày (vui lòng nhập đúng định dạng yyyy-MM-dd): ");
            tg2 = ScannerUntils.inputLocalDate(scanner,"Ngày nhập vào không đúng định dạng hoặc nhập sai !");
            if (tg1.compareTo(tg2)>0){
                System.out.println("Vui lòng nhập lại ! Thời gian từ ngày phải nhỏ hơn thời gian đến ngày !");
            }
            else if (checkToday(tg2) == false && checkToday(tg1) == false){
                System.out.println("Ngày nhập vào phải nhỏ hơn ngày hiện tại !");
            }
            else {
                break;
            }
        }while (true);

        for (int i = 0; i < arr_XoSo.size(); i++) {
            if (arr_XoSo.get(i).getNgayChoi().compareTo(tg1)>=0 && arr_XoSo.get(i).getNgayChoi().compareTo(tg2) <=0){
                ThongBaoGiai(arr_XoSo.get(i));
            }
        }
    }
    public boolean checkToday(LocalDate time){
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        LocalDate today = LocalDate.parse(String.valueOf(date));
        if (today.compareTo(time)<=0){
            return false;
        }
        return true;
    }
}
