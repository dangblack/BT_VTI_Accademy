package TestingSystem.Entity;

import java.util.*;

public class Department{
    private byte id;
    private String name;

    ArrayList<Department> arrayList = new ArrayList<>();
    public Department() {

    }
    public Department(String name) {
        this.id = 0;
        this.name = name;
    }

    public Department(byte id, String name) {
        this.id = id;
        this.name = name;
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

    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id: ");
        setId(scanner.nextByte());
        scanner.nextLine();
        System.out.println("Nhập tên Department: ");
        setName(scanner.nextLine());
    }
    public void NhapDS(){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng Department: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phòng ban " + i + ": ");
            Department department = new Department();
            department.Nhap();
            arrayList.add(department);
        }
    }
    public void HienDS(){
        for(Department department: arrayList){
            System.out.println(department);

        }
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

    public boolean equals(Object obj) {
        Department department2 = (Department) obj;
        if (name.equals(department2.name)){
            return true;
        }
        else {
            return false;
        }
    }
    public void sortASC(){
        Collections.sort(arrayList,Department.compare);
    }

    public static Comparator<Department> compare = new Comparator<Department>() {
        @Override
        public int compare(Department o1, Department o2) {
            String name1 = o1.getName().toUpperCase();
            String name2 = o2.getName().toUpperCase();
            return name1.compareTo(name2);
        }
    };
}

