package Backend;

import Entity.Account;

import java.util.ArrayList;
import java.util.Scanner;

//Xây dựng chức năng đăng nhập
public class SignIn {
    private final String path = "..\\GameLoDe\\src\\App_Data\\Account.txt";
    ArrayList<Account> arr_Account;

    public SignIn() {
        try{
            arr_Account = (ArrayList<Account>) XuLyFile.readFile(path);
        }catch (Exception e){
            arr_Account = new ArrayList<Account>();
        }
        if (arr_Account == null){
            arr_Account = new ArrayList<Account>();
        }
    }

    public void DangNhap(){
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        do {
            System.out.println("Nhập username: ");
            username = ScannerUntils.inputString(scanner,"Username không hợp lệ !");
            System.out.println("Nhập password: ");
            password = ScannerUntils.inputString(scanner,"Password không hợp lệ !");
            if (checkSignIn(username,password) == false){
                System.out.println("Sai tài khoản hoặc mật khẩu !");
            }
            else {
                System.out.println("Đăng nhập thành công !");
                Session.username = username;
                break;
            }
        }while (true);
    }
    public boolean checkSignIn(String username, String password){
        for (Account account: arr_Account) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)){
                Session.account = account;
                return true;

            }
        }
        return false;
    }

}
