package TestingSystem.Frontend.Assignment6.Exercise1;

public class Q3 {
    public static void main(String[] args) {
        int[] so = {1,2,3};
        try {
            System.out.println(so[10]);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
