package TestingSystem.Backend.Xulyfile;

import java.io.*;
import java.util.List;
public class XuLyFile {

     private XuLyFile() {
     }
    public static void writeFile(List danhSach, String diaChi){
        File file = new File(diaChi);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("CO LOI XAY RA KHI MO FILE.");
            }
        }
        FileOutputStream FOut = null;
        ObjectOutputStream OOut = null;
        try {
            FOut = new FileOutputStream(file);
            OOut = new ObjectOutputStream(FOut);
            OOut.writeObject(danhSach);
            System.out.println("GHI FILE THANH CONG");
        } catch (Exception e) {
            System.err.println("CO LOI XAY RA KHI GHI FILE.");
        }
        finally {
            try {
                FOut.close();
                OOut.close();

            } catch (IOException e) {
                System.err.println("CO LOI XAY RA KHI DONG FILE.");
            }
        }
    }

    public static Object readFile(String diaChi){
        FileInputStream FIn = null;
        ObjectInputStream OIn = null;
        Object read = null;
        try {
            FIn = new FileInputStream(new File(diaChi));
            OIn = new ObjectInputStream(FIn);
            read = OIn.readObject();
            return read;
        } catch (Exception e) {
            System.err.println("CO LOI XAY RA KHI DOC FILE.");
        }
        finally {if (read != null)
            System.out.println("DOC FILE THANH CONG!");
            else System.out.println("DOC FILE THAT BAI");
            try {
                FIn.close();
                OIn.close();
            } catch (IOException e) {
                System.err.println("CO LOI XAY RA KHI DONG FIlE.");
            }
        }

        return null;
    }


}
