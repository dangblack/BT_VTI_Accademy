import Model.Account;
import Model.Department;
import Model.Gender;
import Model.Group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ObjectsMethod {
    public static void main(String[] args) {
//        Question1();
//        Question2();
//        Question3();
//        Question4();
//        Question5();
//        Question6();
        Question8();
    }
//    Question 1:
//    In ra thông tin của phòng ban thứ 1 (sử dụng toString())
    public static void Question1(){
        Department department1 = new Department();
        department1.setId((byte) 1);
        department1.setName("Sale");
        System.out.println(department1.toString());
    }
//    Question 2:
//    In ra thông tin của tất cả phòng ban (sử dụng toString())
    public static void Question2(){
        Department department = new Department();
        department.NhapDS();
        department.HienDS();
    }
//    Question 3:
//    In ra địa chỉ của phòng ban thứ 1
    public static void Question3(){
        Department department1 = new Department();
        department1.setId((byte) 1);
        department1.setName("Sale");
        System.out.println(department1.hashCode());

    }
//    Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
    public static void Question4(){
        Department department1 = new Department();
        department1.setId((byte) 1);
        department1.setName("Phòng A");
        if (department1.getName().equals("Phòng A")){
            System.out.println("Có tên là phòng A");
        }else {
            System.out.println("Không tên là phòng A");
        }

    }
//    Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//    không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
    public static void Question5(){
        Department department1 = new Department();
        department1.setId((byte) 1);
        department1.setName("Phòng A");

        Department department2 = new Department();
        department2.setId((byte) 2);
        department2.setName("Phòng A");

        if (department1.equals(department2)){
            System.out.println("Bằng nhau");
        }else {
            System.out.println("Không bằng nhau");
        }

    }
//    Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//    sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//    VD:
//    Ăn gà
//    Nơi Nghỉ ngơi
//    Phòng Business
//    Phòng Sale
//    Uống nước
    public static void Question6(){
        Department department = new Department();
        department.NhapDS();
        System.out.println("Danh sách Department vừa nhập");
        department.HienDS();
        department.sortASC();
        System.out.println("Mảng sau khi sắp xếp: ");
        department.HienDS();
    }
//    Question 7: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//    sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//    VD:
//    Ăn gà5
//    Nơi Nghỉ ngơi
//    Phòng Business
//    Phòng Sale
//    Uống nước
    public static void Question7(){
        Department department = new Department();
        department.NhapDS();
        System.out.println("Danh sách Department vừa nhập");
        department.HienDS();
        department.sortASC();
        System.out.println("Mảng sau khi sắp xếp: ");
        department.HienDS();
    }
    //    Question 8: in ra danh sách học sinh được sắp xếp theo tên
//    VD:
//    Nguyễn Văn A
//    Trần Hưng Đạo
//    Trần Văn Nam
//    Nguyễn Văn Toàn
    public static void Question8(){
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        ArrayList<Account> accountArrayList = new ArrayList<>();
        // create department
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketting";

        // create group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Java Fresher";

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "C# Fresher";

        //Create Account
        account1.id = 1;
        account1.email = "Nguyen Van Toan";
        account1.department = department1;

        Group[] groupOfAccount1 = { group1, group2 };
        account1.groups = groupOfAccount1;

        account1.createDate = new Date("2020/04/22"); // date
        account1.gender = Gender.MALE; // enum
        accountArrayList.add(account1);

        //Create Account
        account2.id = 2;
        account2.email = "Nguyen Van A";
        account2.department = department1;

        Group[] groupOfAccount2 = { group1, group2 };
        account2.groups = groupOfAccount1;


        account2.createDate = new Date("2020/04/22"); // date
        account2.gender = Gender.MALE; // enum
        accountArrayList.add(account2);

        //Create Account
        account3.id = 3;
        account3.email = "Nguyen Van C";
        account3.department = department1;

        Group[] groupOfAccount3 = { group1, group2 };
        account3.groups = groupOfAccount1;

        account3.createDate = new Date("2020/04/22"); // date
        account3.gender = Gender.MALE; // enum
        accountArrayList.add(account3);

        Collections.sort(accountArrayList,Account.compare);

        for (Account x: accountArrayList) {
            System.out.println(x.getEmail());
        }


    }
}
