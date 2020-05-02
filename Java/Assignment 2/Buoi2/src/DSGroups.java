import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DSGroups {
    public ArrayList<Group> arrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void nhapds(){
        int n;
        System.out.println("Nhập số lượng group muốn nhập: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập group thứ " + (i+1));
            Group group = new Group();
            group.nhapGroup();
            arrayList.add(group);
        }

    }
    public void hiends(){
        System.out.println("Danh sách group: ");
        for (Group group:arrayList){
            System.out.println("Group thứ : " + (arrayList.indexOf(group) + 1));
            group.hienGroup();
        }
    }
    Random random = new Random();
    public void randomGroup() {
        int randomGroup = (int) (Math.random() * arrayList.size());
        System.out.println("Random Group: " + arrayList.get(randomGroup));
    }

}
