package Backend;

import Entity.Account;

import java.util.ArrayList;

public class ListAccount {
    private final String path = "D:\\VTI Accademy\\BaiTap\\JAVA BASE\\GameLoDe\\src\\App_Data\\Account.txt";
    ArrayList<Account> arr_Account;

    public ListAccount() {
        try{
            arr_Account = (ArrayList<Account>) XuLyFile.readFile(path);
        }catch (Exception e){
            arr_Account = new ArrayList<Account>();
        }
        if (arr_Account == null){
            arr_Account = new ArrayList<Account>();
        }
    }

    public void showAllAccount(){
        for (Account account: arr_Account) {
            System.out.println(account);
        }
    }
}
