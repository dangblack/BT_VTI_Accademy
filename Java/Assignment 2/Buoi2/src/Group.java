import java.util.Date;
import java.util.Scanner;

public class Group {
    int id;
    String name;
    Date CreateDate;
    Account accounts;

    public Group(int id, String name, Date createDate, Account accounts) {
        this.id = id;
        this.name = name;
        CreateDate = createDate;
        this.accounts = accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }



    public void nhapGroup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id group: ");
        setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên group: ");
        setName(scanner.nextLine());
        setCreateDate(java.util.Calendar.getInstance().getTime());

    }
    public void hienGroup(){
        System.out.println("Id: " + getId());
        System.out.println("Name: " + getName());
    }
}
