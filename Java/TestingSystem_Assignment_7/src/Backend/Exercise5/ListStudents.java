package Backend.Exercise5;

import Backend.Exercise4.IOStream;
import Entity.Student;
import Ultis.ScannerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListStudents {
    List<Student> students = new ArrayList<>();
    public void inputListStudents(){
        System.out.println("Input number student: ");
        int n = ScannerUtils.inputInt();

        // input list student
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.input();
            students.add(student);
        }
    }
    public void printListStudents(){
        for (Student student: students
             ) {
            System.out.println(student);
        }
    }
    public void writeFile(String path) throws Exception {
        IOStream.writeFile(students,path);
    }
    public void readFile(String path){
        students = (List<Student>) IOStream.readFile(path);
    }
}
