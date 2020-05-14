package TestingSystem.Frontend.Assignment6.Exercise1;

import TestingSystem.Frontend.ScannerUntils.ScannerUntils;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) throws Exception {
        checkAge();
    }
    private static void checkAge() throws InvalidAgeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào 1 tuổi :");
//        int age = checkInt(scanner);
        int age = ScannerUntils.inputAge(scanner);
        if (age<18){
            throw new InvalidAgeException("Độ tuổi phải trên 18");
        }else {
            System.out.println("Thành công");
        }
    }

}
