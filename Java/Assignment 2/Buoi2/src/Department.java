import java.util.Scanner;

public class Department {
    byte id;
    String name;

    public Department(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {

    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void nhapDepartment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====Nhập thông tin Department======");
        System.out.println("Nhập id Department: ");
        setId(scanner.nextByte());
        scanner.nextLine();
        System.out.println("Nhập tên Department: ");
        setName(scanner.nextLine());
        System.out.printf("======================================");
    }
    public void hienDepartment(){
        System.out.println("Department ID: " + getId());
        System.out.println("Department Name: " + getName());
    }
}
