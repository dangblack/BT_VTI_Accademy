package TestingSystem.Entity;
public class Student {
    private int id;
    private String name;
    private String hometown;
    private byte score;

    public Student() {

    }

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
    }

    public void setScore(byte score) {
        this.score = score;
    }
    public void setScore(byte score, byte diemcong) {
        this.score = (byte) (score + diemcong);
    }
    public void getInfoStudent(String name, byte score){
        String xeploai = "";
        if (score<=4){
            xeploai = "Yếu";
        }
        else if(score<=6){
            xeploai = "Trung bình";
        }
        else if (score<=8){
            xeploai = "Khá";
        }
        else if (score<=10){
            xeploai = "Giỏi";
        }
        else {
            xeploai = "Điểm không hợp lệ";
        }
        System.out.println("Tên sinh viên: " + name + " điểm: " + score + " xếp loại: " + xeploai);
    }


}