package TestingSystem.Entity.Assignment5.Exercise7;

public class Student implements IStudent{
    private int id;
    private String name;
    private int group;

    public Student(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void diemDanh() {
        System.out.println("Sinh viên "+ getName() +" đang điểm danh...");
    }

    @Override
    public void hocBai() {
        System.out.println("Sinh viên " + getName() + " đang học bài...");
    }

    @Override
    public void diDonVeSinh() {
        System.out.println("Sinh viên "+getName()+" đang dọn vệ sinh...");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }
}
