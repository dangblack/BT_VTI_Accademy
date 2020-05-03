import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class String4 {
    public static void main(String[] args) {
        //Question1();
//        Question2();
//        Question3();
//        Question4();
//        Question5();
//        Question6();
//        Question7();
//        Question8();
//        Question9();
//        Question10();
//        Question11();
//        Question12();
//        Question13();
//        Question14();
//        Question15();
//        Question16();
//        Question17();
//        Question18();
        test();
    }
    //    Question 1:
//    Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//            thể cách nhau bằng nhiều khoảng trắng );
    public static void Question1(){
        String s1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        s1 = scanner.nextLine();
        System.out.println("Số kí tự: " + s1.length());
        scanner.close();
    }
//    Question 2:
//    Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
    public static void Question2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi 1: ");
        String s1 = scanner.nextLine();
        System.out.println("Nhập chuỗi 2: ");
        String s2 = scanner.nextLine();
        System.out.println("Sau khi nối chuỗi : "  + s1.concat(s2));
        scanner.close();
    }
//    Question 3:
//    Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
//    viết hoa chữ cái đầu thì viết hoa lên
    public static void Question3(){
        String ten;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Tên: ");
        ten = scanner.nextLine();
        System.out.println(ten.trim().substring(0,1).toUpperCase() + ten.substring(1));
        scanner.close();

    }
//    Question 4:
//    Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//    của người dùng ra
//    VD:
//    Người dùng nhập vào "Nam", hệ thống sẽ in ra
//"Ký tự thứ 1 là: N"
//        "Ký tự thứ 1 là: A"
//        "Ký tự thứ 1 là: M"
    public static void Question4(){
        String ten;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        ten = scanner.nextLine();
        ten = ten.trim().toUpperCase();
        for (int i = 0; i < ten.length(); i++) {
            System.out.println("Ký tự thứ " + i + " là: " + ten.charAt(i));
        }
        scanner.close();
    }
//    Question 5:
//    Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//    dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
    public static void Question5(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ: ");
        String ho = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Họ tên đầy đủ: " + ho.concat(ten));
        scanner.close();

    }
//    Question 6:
//    Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//    sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//    VD:
//    Người dùng nhập vào "Nguyễn Văn Nam"
//    Hệ thống sẽ in ra
//"Họ là: Nguyễn"
//        "Họ là: Văn"
//        "Họ là: Nam"3
    public static void Question6(){
        String hoten;
        String ho, hodem, ten;
        String s;
        int i,j,k=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập họ tên đầy đủ:");
        hoten = scanner.nextLine();

        //Chuẩn hóa xâu
        hoten = hoten.trim();
        //Hàm indexOf: Trả về vị trí của s2 trong s1
        //s1: hoten, s2: "  "
        //Hàm replaceAll(s1,s2): thay thể tất cả chuỗi s1 thành s2 (nhưng chỉ thay thế 1 lần)
        // \\s+ : Đại diện cho reglex. Ở đây là kí tự trắng
        hoten = hoten.replaceAll("\\s+"," ");
        System.out.println("Họ tên sau khi chuẩn hóa: " + hoten);
        for (i = hoten.length() - 1; i>=0 ; i--) {
            s = hoten.substring(i,i+1);
            if (s.equals(" ")){
                break;
            }
        }

        ten = hoten.substring(i+1);
        System.out.println(ten);
        for (j = 0; j<= hoten.length(); j++){
            s = hoten.substring(j,j+1);
            if (s.equals(" ")){
                break;
            }
        }
        ho = hoten.substring(0,j);
        System.out.println(ho);
        String kt = hoten.substring(j,j+1);
        System.out.println(kt);

        if (!kt.equals(" ")){
            System.out.println("không có họ đệm !");
            hodem= hoten.substring(j+1,i);
            System.out.println(hodem);
        }
        scanner.close();
    }
//    Question 7:
//    Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//    chuẩn hóa họ và tên của họ như sau:
//    a) Xóa dấu cách ở đầu và cuối của chuỗi người dùng nhập vào
//    VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//    chuẩn hóa thành "nguyễn văn nam"
//    b) Viết hoa chữ cái mỗi từ của người dùng
//    VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//    chuẩn hóa thành "Nguyễn Văn Nam"
    public static void Question7(){
        Scanner scanner = new Scanner(System.in);
        String hoten;
        System.out.println("Nhập họ tên đầy đủ");
        hoten = scanner.nextLine();
        hoten = hoten.trim();
        hoten = hoten.replaceAll("\\s+"," ");
        String[] arr = hoten.split(" ");
        hoten = "";
        for (String x : arr){
            hoten = hoten + (x.substring(0, 1).toUpperCase() + x.substring(1));
            hoten = hoten + " ";
        }
        System.out.println("họ tên sau khi chuẩn hóa: "+ hoten);
    }
//    Question 8:
//    In ra tất cả các group có chứa chữ "Java"
    public static void Question8(){
        String[] arrGroupName = {"Java with Duy Nguyễn", "Cách qua môn gia va", "Học Java có khó không?"};
        String[] arrChildGroupName;

        for (String x: arrGroupName){
            arrChildGroupName = x.split("\\s");
            for (String y :arrChildGroupName){
                if (y.toUpperCase().equals("JAVA")){
                    System.out.println(x);
                }
            }
        }
    }
//    Question 9:
//    In ra tất cả các group "Java"
    public static void Question9(){
        String[] arrGroupName = {"Java", "C#", "C++"};

        for (String x: arrGroupName){
            if (x.toUpperCase().equals("JAVA")){
                System.out.println(x);
            }
        }
    }
//    Question 10:
//    Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//    Nếu có xuất ra “OK” ngược lại “KO”.
//    Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
    public static void Question10(){
        Scanner scanner = new Scanner(System.in);
        String s1,ss, s2;
        System.out.println("Nhập chuỗi 1");
        s1= scanner.nextLine();
        System.out.println("Nhập chuỗi 2");
        s2= scanner.nextLine();
        ss="";
        for (int i=s1.length()-1; i>=0; i--){
            ss+=s1.substring(i,i+1);
        }
        if (s2.equals(ss)){
            System.out.println("Đây là chuỗi đảo ngược !");
        }
        scanner.close();
    }
//    Question 11: Character unique
//    Tìm ký tự chỉ xuất hiện một lần trong chuỗi
//    Nếu có nhiều hơn một thì xuất ra màn hình ký tự đầu tiên.
//    Nếu không có ký tự nào unique xuất ra “NO”.
    public static void Question11(){
        Scanner scanner = new Scanner(System.in);
        String chuoi;

        System.out.println("Mời bạn nhập vào một chuỗi: ");
        chuoi = scanner.nextLine();
        if (chuoi == null || chuoi.isEmpty()){
            System.out.println("NO");
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chuoi.length(); i++) {
            if (map.containsKey(chuoi.charAt(i))){
                map.compute(chuoi.charAt(i),(k, v) -> v + 1);
            }
            else {
                map.put(chuoi.charAt(i),1);
            }
        }
        for (int i = 0; i < chuoi.length(); i++) {
            if (map.get(chuoi.charAt(i)) == 1){
                System.out.println(chuoi.charAt(i));
                return;
            }

        }
        System.out.println("NO");
    }
//    Question 12: Reverse String
//    Đảo ngược chuỗi sử dụng vòng lặp
    public static void Question12(){
        Scanner scanner = new Scanner(System.in);
        String s1,ss;
        System.out.println("Nhập chuỗi 1");
        s1= scanner.nextLine();
        ss="";
        for (int i=s1.length()-1; i>=0; i--){
//            ss+=s1.substring(i,i+1);
            ss+=s1.charAt(i);
        }
        System.out.println(ss);
        scanner.close();

    }
//    Question 13: String not contains digit
//    Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
//    lại true.
//    Ví dụ:
//            "abc" => true
//            "1abc", "abc1", "123", "a1bc", null => false
    public static void Question13(){
        Scanner scanner = new Scanner(System.in);
        String s1;
        System.out.println("Nhập chuỗi: ");
        s1 = scanner.nextLine();
        for (int i = 0; i < s1.length(); i++) {
            if (checkKeyNumber(s1.charAt(i))){
                System.out.println("False");
                return;
            }

        }
        System.out.println("True");
        scanner.close();

    }
    public static boolean checkKeyNumber(char ch){
        if (ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }

//    Question 14: Replace character
//    Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
//    cho trước.
//    Ví dụ:
//            "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
    public static void Question14(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder s1;
        char ch1, ch2;
        System.out.println("Nhập chuỗi: ");
        s1 = new StringBuilder(scanner.nextLine());
        System.out.println("Nhập kí tự muốn chuyển: ");
        ch1 = scanner.nextLine().toCharArray()[0];
        System.out.println("Nhập kí tự sẽ chuyển: ");
        ch2 = scanner.nextLine().toCharArray()[0];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ch1){
                s1.setCharAt(i,ch2);
//                s1.replace(i,i+1, String.valueOf(ch2));
            }
        }
        System.out.println("Chuoi sau khi chuyen: " + s1);
        scanner.close();
    }
//    Question 15: Revert string by word
//    Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
//    thư viện.
//    Ví dụ: " I am developer " => "developer am I".4
//    Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//    Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
//    chuỗi theo dấu cách
    public static void Question15(){
        Scanner scanner = new Scanner(System.in);
        String s1;
        System.out.println("Chuỗi: ");
        s1 = scanner.nextLine();
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+"," ");
//        String[] arr = s1.split(" ");
        ArrayList arr = new ArrayList();
        String x = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != 32){
                x += s1.charAt(i);

            }
            if(s1.charAt(i) == 32 || i == s1.length() - 1)
            {
                arr.add(x);
                x="";
            }
        }
        s1="";
        for (int i = arr.size()-1; i >=0 ; i--)
        {
            s1 += arr.get(i) + " ";
        }
        s1 = s1.trim();
        System.out.println(s1);

    }
//    Question 16:
//    Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//    bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
//    hình “KO”.
    public static void Question16(){
        Scanner scanner = new Scanner(System.in);
        String s1;
        String s2;
        int n;
        System.out.println("Chuỗi: ");
        s1 = scanner.nextLine();
        System.out.println("Nhập n: ");
        n = scanner.nextInt();
        if (s1 == null || s1.isEmpty()){
            System.out.println("No");
            return;
        }
        if (s1.length() % n != 0){
            System.out.println("No");
            return;
        }

        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < s1.length()/n; i++) {
            arrayList.add(s1.substring(i*n,(i+1)*n));
        }
        for (String x: arrayList) {
            System.out.println(x + "\n");
        }
        scanner.close();
    }
//    Question 17: Character duplicate
//    Tìm và in ra các ký tự xuất hiện nhiều hơn một lần trong String cho
//    trước không phân biệt chữ hoa hay chữ thường. Nếu các ký tự trong
//    chuỗi đều là duy nhất thì xuất ra “NO”.
//    Ví dụ chuỗi “Java” thì có ký tự ‘a’.
public static void Question17(){
    Scanner scanner = new Scanner(System.in);
    String chuoi;

    System.out.println("Mời bạn nhập vào một chuỗi: ");
    chuoi = scanner.nextLine();
    chuoi = chuoi.toLowerCase();
    if (chuoi == null || chuoi.isEmpty()){
        System.out.println("NO");
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < chuoi.length(); i++) {
        if (map.containsKey(chuoi.charAt(i))){
            map.compute(chuoi.charAt(i),(k, v) -> v + 1);
        }
        else {
            map.put(chuoi.charAt(i),1);
        }
    }
    for (int i = 0; i < chuoi.length(); i++) {
        if (map.get(chuoi.charAt(i)) > 1){
            System.out.println(chuoi.charAt(i));
            return;
        }
    }
    System.out.println("NO");
}
//    Question 18: Remove character duplicate
//    Cho một chuỗi str, xoá các ký tự xuất hiện nhiều hơn một lần trong
//    chuỗi và chỉ giữ lại ký tự đầu tiên
//    Ví dụ: bananas => bans
    public static void Question18(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder chuoi;

        System.out.println("Mời bạn nhập vào một chuỗi: ");
        chuoi = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < chuoi.length()-1; i++) {
            for (int j = i+1; j< chuoi.length(); j++){
                if (chuoi.charAt(i) == chuoi.charAt(j)){
                    chuoi.deleteCharAt(j);
                    j--;
                }
            }
        }
        System.out.println(chuoi);
    }
    public static void test() {
        Scanner kb = new Scanner (System.in);
        String s1 = "";

        System.out.println("Nhập chuỗi: ");
        s1 = kb.nextLine();

        uniqueCharacters(s1);
    }
    public static void uniqueCharacters(String test){
        //Khai báo một string tạm
        String temp = "";
        //Chạy lấy từng kí tự trong chuỗi
        for (int i = 0; i < test.length(); i++){
            //Lấy kí tự
            char ch = test.charAt(i);
            //Hàm indexOf: Trả về chỉ số của giá trị ký tự đã cho. Không thấy sẽ ra -1
            //Nếu không tìm thấy kí tự ch trong chuỗi tạm => Add kí tự vào chuỗi tạm
            if (temp.indexOf(ch) < 0){
                temp = temp + ch;
            } else { //Nếu thấy rồi thì khởi tạo lại chuỗi tạm bằng hàm Replace
                temp = temp.replace(String.valueOf(ch), "");
            }
        }
        System.out.println(temp);

    }
}

