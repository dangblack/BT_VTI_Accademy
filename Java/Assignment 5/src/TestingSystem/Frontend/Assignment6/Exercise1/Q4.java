package TestingSystem.Frontend.Assignment6.Exercise1;


public class Q4 {

    public static void main(String[] args) {
        String[] arr_Departments = {"Sale","Dev","Marketing"};
        getIndex(10,arr_Departments);
    }
    public static void getIndex(int index,String[] arr_Departments){
        try {
            System.out.println(arr_Departments[index]);
        }catch (Exception e){
            System.out.println("Cannot find department");
        }
    }
}
