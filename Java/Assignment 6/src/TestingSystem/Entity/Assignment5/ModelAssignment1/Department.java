package TestingSystem.Entity.Assignment5.ModelAssignment1;

import TestingSystem.Frontend.ScannerUntils.ScannerUntils;

import java.util.*;

public class Department{
    private Scanner scanner;
    private int id;
    private String name;

    ArrayList<Department> arrayList = new ArrayList<>();
    public Department() {

    }
    public Department(String name) {
        this.id = 0;
        this.name = name;
    }

    public Department(int id, String name) throws Exception {
        scanner = new Scanner(System.in);
        this.id = inputId();
        this.name = inputName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Kiểm tra input contructor
    public int inputId() throws Exception{
        System.out.println("Nhập id");
        int id = ScannerUntils.inputInt(scanner,"Vui lòng nhập vào một số !");
        return id;
    }
    public String inputName() throws Exception{
        System.out.println("Nhập id");
        String name = ScannerUntils.inputString(scanner,"Vui lòng không được để trống!");
        return name;
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
        setId(ScannerUntils.inputInt(scanner,"Vui lòng nhập vào một số !"));
        scanner.nextLine();
        System.out.println("Nhập tên Department: ");
        setName(ScannerUntils.inputString(scanner,"Input nhập vào bị trống"));
    }
    public void NhapDS(){
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng Department: ");
        n = ScannerUntils.inputInt(scanner,"Vui lòng nhập vào một số !");

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

