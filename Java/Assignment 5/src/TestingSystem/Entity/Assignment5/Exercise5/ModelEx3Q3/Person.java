package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q3;

public abstract class Person {
    private String name;

    public Person() {

    }
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
