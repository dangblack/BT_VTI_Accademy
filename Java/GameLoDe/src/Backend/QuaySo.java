package Backend;

import Entity.Account;
import Entity.XoSo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuaySo {
    private final String path = "..\\GameLoDe\\src\\App_Data\\XoSo.txt";
    private static final String CHAR_LIST = "1234567890";
    XoSo xoSo = new XoSo();
    ArrayList<XoSo> arr_XoSo;

    public QuaySo() {
        try{
            arr_XoSo = (ArrayList<XoSo>) XuLyFile.readFile(path);
        }catch (Exception e){
            arr_XoSo = new ArrayList<XoSo>();
        }
        if (arr_XoSo == null){
            arr_XoSo = new ArrayList<XoSo>();
        }
    }


    public void RandomGiai(String[] giai){
        for (int i = 0; i < giai.length; i++){
            StringBuilder sb = new StringBuilder(5);
            for (int j = 0; j<5;j++){
                int index = (int)(CHAR_LIST.length() * Math.random());
                sb.append(CHAR_LIST.charAt(index));
            }
            giai[i] = sb.toString();
        }
    }
    public void luuGiai(XoSo xoSo){
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        LocalDate today = LocalDate.parse(String.valueOf(date));

        if (arr_XoSo.size() == 0){
            arr_XoSo.add(xoSo);
        }
        else if (arr_XoSo.get(arr_XoSo.size()-1).equals(today)){
            arr_XoSo.set(arr_XoSo.size()-1,xoSo);
        }
        else {
            arr_XoSo.add(xoSo);
        }
        XuLyFile.writeFile(arr_XoSo,path);
    }

    public void QuayXS(){
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        LocalDate today = LocalDate.parse(String.valueOf(date));
        RandomGiai(xoSo.getDb());

        RandomGiai(xoSo.getNhat());

        RandomGiai(xoSo.getNhi());

        RandomGiai(xoSo.getBa());

        RandomGiai(xoSo.getTu());

        RandomGiai(xoSo.getNam());

        RandomGiai(xoSo.getSau());

        RandomGiai(xoSo.getBay());

        xoSo.setNgayChoi(today);

        luuGiai(xoSo);
    }
    public void inGiai(String[] giai){
        for (int i = 0; i < giai.length; i++) {
            System.out.print(giai[i] + " ");
        }
        System.out.println("\n");
    }
    public void ThongBaoGiai(){
        System.out.println("=========GIẢI==========");
        System.out.println("Ngày chơi: " + xoSo.getNgayChoi());
        System.out.println("=======================");
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
}
