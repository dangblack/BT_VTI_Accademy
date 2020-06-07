package Frontend;

import Backend.Exercise5.ListStudents;
import Entity.Student;
import Ultis.ScannerUtils;

import java.util.ArrayList;
import java.util.List;

public class Question1 {
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String path = "D:\\VTI Accademy\\BaiTap\\JAVA BASE\\TestingSystem_Assignment_7\\src\\AppData\\StudentInformation.txt";
        ListStudents listStudents = new ListStudents();
        int choose;
        do {
            menuTODOStudent();
            choose = ScannerUtils.inputInt();
            switch (choose){
                case 1:
                    listStudents.inputListStudents();
                    break;
                case 2:
                    listStudents.printListStudents();
                    break;
                case 3:
                    listStudents.writeFile(path);
                    break;
                case 4:
                    listStudents.readFile(path);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Input wrong ! Please input again :) ");
                    break;
            }
        }while (choose!=5);
    }
    public static void menuTODOStudent(){
        System.out.println("===============MENU=================");
        System.out.println("=1. Input list student             =");
        System.out.println("=2. Print list student             =");
        System.out.println("=3. Write student                  =");
        System.out.println("=4. Read student                   =");
        System.out.println("=5. Exit                           =");
        System.out.println("====================================");
        System.out.println("Bạn chọn:                           ");
    }

}
