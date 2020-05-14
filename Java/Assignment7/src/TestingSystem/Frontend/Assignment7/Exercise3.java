package TestingSystem.Frontend.Assignment7;

import java.io.File;
import java.io.IOException;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        Q2();
    }
    public static boolean Q1(){
        File file = new File("C:\\Users\\Admin\\Destop\\Test.txt");
        if (file.exists()){
            System.out.println("True");
            return true;
        }else {
            System.out.println("False");
            return false;
        }
    }
    public static void Q2() throws IOException {
        File file = new File("C:\\Users\\Admin\\Destop\\Test.txt");
        if (!Q1()){

        }
        else {
            System.out.println("Error ! File Exist");
        }
    }
}
