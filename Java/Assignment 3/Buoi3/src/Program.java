import java.util.Date;

public class Program {
    public static void main(String[] args) {
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

        // create account
        Account account1 = new Account();
        account1.id = 1;
        account1.email = "NguyenVanA@gmail.com";
        account1.department = department1;

        Group[] groupOfAccount1 = { group1, group2 };
        account1.groups = groupOfAccount1;

        account1.createDate = new Date("2020/04/22"); // date
        account1.gender = Gender.MALE; // enum

        System.out.println("Th�ng tin ph�ng ban 1: ");

        System.out.println("name: " + department1.name);
        System.out.println("id: " + department1.id);
        System.out.println("\n");

        System.out.println("Th�ng tin ph�ng ban 2: ");

        System.out.println("name: " + department2.name);
        System.out.println("id: " + department2.id);
        System.out.println("\n");

        System.out.println("Th�ng tin account 1: ");

        System.out.println("id: " + account1.id);
        System.out.println("Email: " + account1.email);
        System.out.println("Department Name: " + account1.department.name);
        System.out.println("Create Date: " + account1.createDate);
        System.out.println("Gender: " + account1.gender);
    }
}
