package Entity;

import java.io.Serializable;

public class Account implements Serializable {
    private final int idAccount;
    private final String username;
    private String password;
    private boolean quyen; //0: Quyền User, 1: Quyền Admin
    private int tien;

    public Account(int idAccount, String username, String password, boolean quyen) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.quyen = quyen;
        this.tien = 1000000;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isQuyen() {
        return quyen;
    }

    public void setQuyen(boolean quyen) {
        this.quyen = quyen;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", quyen=" + quyen +
                '}';
    }
}
