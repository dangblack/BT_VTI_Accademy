package TestingSystem.Backend.Assignment5.Exercise7;

import TestingSystem.Entity.Assignment5.Exercise7.Student;

public class Q1 {
    public void hienQ1(){
        Student[] students = new Student[3];
        students[0] = new Student(1,"Nguyễn Văn A",1);
        students[1] = new Student(1,"Nguyễn Văn B",2);
        students[2] = new Student(1,"Nguyễn Văn C",3);
        for (Student student: students) {
            student.diemDanh();
            student.hocBai();
        }

    }
}
