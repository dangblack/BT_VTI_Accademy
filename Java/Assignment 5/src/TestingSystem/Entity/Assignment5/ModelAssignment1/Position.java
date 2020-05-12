package TestingSystem.Entity.Assignment5.ModelAssignment1;

import TestingSystem.Frontend.ScannerUntils.ScannerUntils;

import java.util.Scanner;

public class Position {
    private Scanner scanner;
    public int id;
    public String name;

    public Position() {

    }

    public Position(int id, String name) throws Exception {
        this.id = inputId();
        this.name = inputName();
    }
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
