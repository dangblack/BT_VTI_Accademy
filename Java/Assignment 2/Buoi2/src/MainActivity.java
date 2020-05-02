import java.time.LocalDateTime;
import java.util.*;

public class MainActivity {

    public static void main(String[] args) {
        int chon;
        DSGroups dsGroups = new DSGroups();
        DSAccount dsAccount = new DSAccount();
        DSDepartments dsDepartments = new DSDepartments();
        Scanner scanner = new Scanner(System.in);
        do{
            menu();
            chon = scanner.nextInt();
            switch (chon){
                case 1:
                    System.out.println("=====NHẬP ACCOUNT======");
                    dsAccount.nhapds();
                    dsAccount.hiends();
                    break;
                case 2:
                    dsDepartments.nhapds();
                    dsDepartments.hiends();
                    break;

                case 3:
                    dsGroups.nhapds();
                    dsGroups.hiends();
                    break;
                case 4:
                    dsAccount.hiends();
                    System.out.println("Nhập username: ");
                    String username = scanner.nextLine();
                    scanner.nextLine();
                    dsGroups.hiends();
                    Group group = new Group();
                    Account account = new Account();
                    System.out.println("Nhập Groupname: ");
                    String groupname = scanner.nextLine();
                    group.setName(groupname);
                    account.setGroups(group);
                    break;
                case 5:
                    Group group1 = new Group();
                    Account account1 = new Account();

                    dsAccount.hiends();
                    System.out.println("Nhập username: ");
                    String username1 = scanner.nextLine();
                    account1.setEmail(username1);

                    scanner.nextLine();

                    dsGroups.hiends();

                    System.out.println("Nhập Groupname: ");
                    String groupname1 = scanner.nextLine();

                    group1.setAccounts(account1);
                    break;
                case 6:
                    dsGroups.randomGroup();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại !");
                    break;
            }
        }while (chon!=0);
    }
    public static void menu(){
        System.out.println("=================MENU====================");
        System.out.println("|| 1. Tạo Accounts                      ||");
        System.out.println("|| 2. Tạo Departments                   ||");
        System.out.println("|| 3. Tạo Groups                        ||");
        System.out.println("|| 4. Thêm Account vào Group            ||");
        System.out.println("|| 5. Thêm Group vào Account            ||");
        System.out.println("|| 6. Thêm Account vào Group ngẫu nhiên ||");
        System.out.println("|| 0. Thoát                             ||");
        System.out.println("=========================================");
        System.out.println("Bạn chọn: ");
    }

}
