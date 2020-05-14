package TestingSystem.Entity.Assignment5.Exercise5.ModelEx3Q3;

public abstract class Student extends Person{
    private int id;

    public Student() {

    }
    public Student(int id) {
        this.id = id;
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
