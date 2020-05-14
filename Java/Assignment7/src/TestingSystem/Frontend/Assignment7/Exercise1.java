package TestingSystem.Frontend.Assignment7;

import TestingSystem.Entity.Assignment7.Student;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
        Q1();
    }
    public static void Q1(){
        Student[] students = new Student[3];
        students[0] = new Student(1,"Nguyễn Văn A");
        students[1] = new Student(2,"Nguyễn Văn B");
        students[2] = new Student(3,"Nguyễn Văn C");
        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].toString());
        }

        Student.college = "Đại học công nghệ";

        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].toString());
        }
    }
}
