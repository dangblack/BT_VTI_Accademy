package TestingSystem.Frontend.Assignment6.Exercise1;

public class Q1_2 {
    public static void main(String[] args) {
        try{
            float result = device(7,0);
        }
        catch (Exception e){
            System.out.println("cannot device 0 !");
        }
        finally {
            System.out.println("divide completed !");
        }

    }

    private static float device(int a, int b) {
        return a/b;
    }
}
