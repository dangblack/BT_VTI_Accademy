import java.util.Random;
import java.util.Scanner;

public class DatatypeCasting {
    public static void main(String[] args) {
        //Question1();
        //Question2();
        Quesiton5();
    }
//    Question 1:
//    Khai báo 2 số lương có kiểu dữ liệu là float.
//    Khởi tạo Lương của Model.Account 1 là 5240.5 $
//    Khởi tạo Lương của Model.Account 2 là 10970.055$
//    Khai báo 1 số int để làm tròn Lương của Model.Account 1 và in số int đó ra
//    Khai báo 1 số int để làm tròn Lương của Model.Account 2 và in số int đó ra
    public static void Question1(){
        float Salary1;
        float Salary2;
        Salary1 = (float) 5240.5;
        Salary2 = (float) 10970.055;
        System.out.println("Salary1: " + Salary1  + "||  Salary2: " + Salary2);
        int roundSalary1 = (int) Salary1;
        int roundSalary2 = (int) Salary2;
        System.out.println("roundSalary1: " + roundSalary1  + " ||  roundSalary2: " + roundSalary2);
    }
//    Question 2:
//    Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//            có số 0 ở đầu cho đủ 5 chữ số)

    //    Question 3:
//    Lấy 2 số cuối của số ở Question 2 và in ra.
//    Gợi ý:
//    Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//    Cách 2: chia lấy dư số đó cho 100

    public static void Question2(){
        Random random = new Random();
        int min = 0;
        int max = 99999;
        int a = (int)(Math.random()*max)+min;
        while (a<10000){
            a = a*10;
        }
        System.out.printf("===Question2======\n");
        System.out.println("Số ngẫu nhiên: " + a);
        System.out.println("======Question3=======");
        String b = String.valueOf(a);
        System.out.println("Hai số cuối: " + b.substring(3));
    }

//    Question 4:
//    Khai báo 1 số byte có giá trị bằng số lượng group mà account thứ 1 đã
//    tham gia
    public static void Question4(){
        //Vì làm project mới nên bỏ phần này
    }
//    Question 5:
//    Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
    public static void Quesiton5(){
        int a,b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a = ");
        a = scanner.nextInt();
        scanner.nextLine();
        do {
            System.out.println("Nhập b = ");
            b = scanner.nextInt();
            if (b == 0){
                System.out.println("Vui lòng nhập b khác 0 !");
            }
        }while (b==0);
        System.out.println("Thương: " + (float)a/(float)b);
    }

}
