import java.util.ArrayList;
import java.util.Scanner;

public class DSDepartments {
    public ArrayList<Department> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void nhapds(){
        int n;
        System.out.println("Nhập số lượng Department muốn nhập: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập group thứ " + (i+1));
            Department department = new Department();
            department.nhapDepartment();
            arrayList.add(department);
        }

    }
    public void hiends(){
        System.out.println("\n============Danh sách department: ============\n");
        for (Department department:arrayList){
            System.out.println("----------Department thứ : " + (arrayList.indexOf(department) + 1) +"------------");
            department.hienDepartment();
        }
    }
}
