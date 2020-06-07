package Entity;

import Ultis.ScannerUtils;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private int id;
    static int count = 0;
    private String name;

    public Student() {
        this.id = ++count;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        name = ScannerUtils.inputName();
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
