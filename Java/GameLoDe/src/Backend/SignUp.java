package Backend;


import Entity.Account;

import java.util.ArrayList;

import java.util.Scanner;

public class SignUp {
    private final String path = "..\\GameLoDe\\src\\App_Data\\Account.txt";
    ArrayList<Account> arr_Account;

    public SignUp() {
        try{
            arr_Account = (ArrayList<Account>) XuLyFile.readFile(path);
        }catch (Exception e){
            arr_Account = new ArrayList<Account>();
        }
        if (arr_Account == null){
            arr_Account = new ArrayList<Account>();
        }
    }

    public void DangKy(){
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);
        int id = 1000 + arr_Account.size();
        System.out.println("Nhập username");

        do {
            username = ScannerUntils.inputString(scanner,"User name không hợp lệ !");
            if (checkAccount(username) == true){
                System.out.println("Account bị trùng, vui lòng nhập lại !");
            }
            else {
                break;
            }
        }while (true);
        System.out.println("Nhập password");
        password = ScannerUntils.inputString(scanner,"Password không hợp lệ !");

        Account account = new Account(id,username,password,true);
        arr_Account.add(account);
        XuLyFile.writeFile(arr_Account,path);
    }
    public boolean checkAccount(String username){
        for (Account account: arr_Account) {
            if (account.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
