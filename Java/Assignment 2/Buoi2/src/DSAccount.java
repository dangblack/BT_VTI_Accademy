import java.util.ArrayList;
import java.util.Scanner;

public class DSAccount {
    public ArrayList<Account> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void nhapds(){
        int n;
        System.out.println("Nhập số lượng account muốn nhập: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập account thứ " + (i+1));
            Account account = new Account();
            account.nhapAccount();
            arrayList.add(account);
        }

    }
    public void hiends(){
        System.out.println("=================Danh sách Acount: ===========");
        for (Account account:arrayList){
            System.out.println("----------Account : " + (arrayList.indexOf(account) + 1) + "---------------");
            account.hienAccount();
        }
    }

}
