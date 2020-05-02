import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Account {
    int id;
    String email;
    Department department;
    Group groups;
    Date createDate;
    Gender gender;
    Position position;
    ArrayList<Department> departmentArrayList;
    public Account() {

    }

    public void setGroups(Group groups) {
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public void nhapAccount(){
        DSGroups dsGroups = new DSGroups();
        DSDepartments dsDepartments = new DSDepartments();
        Scanner scanner = new Scanner(System.in);
        Department department = new Department();

        System.out.println("Nhập id:" );
        setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập email: ");
        setEmail(scanner.nextLine());

        System.out.println("Nhập Department: ");
        System.out.println("Nhập Department ID: ");
        department.setId(scanner.nextByte());
        scanner.nextLine();
        System.out.println("Nhập Department Name");
        department.setName(scanner.nextLine());
        setDepartment(department);

        setCreateDate(java.util.Calendar.getInstance().getTime());
        System.out.println("Nhập giới tính: ");
        String gt = scanner.nextLine();
        if (gt.equals("MALE")){
            setGender(Gender.MALE);
        }
        else if (gt.equals("FEMALE")){
            setGender(Gender.FEMALE);
        }
        else {
            setGender(Gender.UNKNOWN);
        }
        System.out.println("Nhập position: ");
        Position position = new Position();
        System.out.println("Nhập position ID");
        position.setPositionID(scanner.nextByte());
        scanner.nextLine();
        System.out.println("Nhập position Name: ");
        position.setPositionName(scanner.nextLine());
        setPosition(position);


    }

    public void hienAccount(){
        System.out.println("========================================");
        System.out.println("Account ID: " + getId());
        System.out.println("Email " + getEmail());
        System.out.println("Department Name: " + department.getName() );
        System.out.println("Gender: " + getGender());
        System.out.println("Position: " + position.getPositionName());
        System.out.println("Group: " + groups.getName());
    }

}
