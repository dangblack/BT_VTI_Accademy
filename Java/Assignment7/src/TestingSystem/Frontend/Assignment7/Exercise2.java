package TestingSystem.Frontend.Assignment7;

import TestingSystem.Entity.Assignment7.MyMath;
import TestingSystem.Entity.Assignment7.Student;

import java.io.File;

public class Exercise2 {
    public static void main(String[] args) {
//        Q1();
//        Q2();

    }
    public static void Q1(){
        MyMath myMath = new MyMath();
        System.out.println(myMath.sum(5));
    }
    public static void Q2(){
        Student student = new Student(1,"Nguyễn Hải Đăng");
        System.out.println(student.toString());

    }

}
