package Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class XoSo implements Serializable {
    private String[] db = new String[1];
    private String[] nhat = new String[1];
    private String[] nhi = new String[2];
    private String[] ba = new String[6];
    private String[] tu = new String[4];
    private String[] nam = new String[6];
    private String[] sau = new String[3];
    private String[] bay = new String[4];
    private LocalDate ngayChoi;

    public XoSo() {

    }

    public void setNgayChoi(LocalDate ngayChoi) {
        this.ngayChoi = ngayChoi;
    }

    public XoSo(String[] db, String[] nhat, String[] nhi, String[] ba, String[] tu, String[] nam, String[] sau, String[] bay, LocalDate ngayChoi) {
        this.db = db;
        this.nhat = nhat;
        this.nhi = nhi;
        this.ba = ba;
        this.tu = tu;
        this.nam = nam;
        this.sau = sau;
        this.bay = bay;
        this.ngayChoi = ngayChoi;
    }

    public LocalDate getNgayChoi() {
        return ngayChoi;
    }





    public String[] getDb() {
        return db;
    }

    public void setDb(String[] db) {
        this.db = db;
    }

    public String[] getNhat() {
        return nhat;
    }

    public void setNhat(String[] nhat) {
        this.nhat = nhat;
    }

    public String[] getNhi() {
        return nhi;
    }

    public void setNhi(String[] nhi) {
        this.nhi = nhi;
    }

    public String[] getBa() {
        return ba;
    }

    public void setBa(String[] ba) {
        this.ba = ba;
    }

    public String[] getTu() {
        return tu;
    }

    public void setTu(String[] tu) {
        this.tu = tu;
    }

    public String[] getNam() {
        return nam;
    }

    public void setNam(String[] nam) {
        this.nam = nam;
    }

    public String[] getSau() {
        return sau;
    }

    public void setSau(String[] sau) {
        this.sau = sau;
    }

    public String[] getBay() {
        return bay;
    }

    public void setBay(String[] bay) {
        this.bay = bay;
    }
}
