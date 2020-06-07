package Backend.Exercise4;


import Backend.Exercise3.FileManagement;

import java.io.*;
import java.util.List;

public class IOStream {

    private IOStream() {
    }

    /**
     * This method is write file
     * @param list
     * @param path
     * @throws Exception
     */
    public static void writeFile(List list, String path) throws Exception {
        File file = new File(path);

        // Check file exists
        FileManagement.CheckFileIsExists(path);

        // Write file

        FileOutputStream FOut = null;
        ObjectOutputStream OOut = null;

        try {

            FOut = new FileOutputStream(file);
            OOut = new ObjectOutputStream(FOut);
            OOut.writeObject(list);
            System.out.println("Write file success");

        } catch (Exception e) {
            throw new Exception(e);
        }
        finally {
            // Close file
            try {
                FOut.close();
                OOut.close();

            } catch (IOException e) {
                System.err.println("Close file false !");
            }
        }
    }

    /**
     * This method is read file
     * @param path
     * @return
     */
    public static Object readFile(String path){
        // Check file exists
        FileManagement.CheckFileIsExists(path);

        // Read File
        FileInputStream FIn = null;
        ObjectInputStream OIn = null;
        Object read = null;
        try {
            FIn = new FileInputStream(new File(path));
            OIn = new ObjectInputStream(FIn);
            read = OIn.readObject();
            return read;
        } catch (Exception e) {
            System.err.println("Read file false !");
        }
        finally {
            if (read != null){
                System.out.println("Write file success !");
            }
            else{
                System.out.println("File not found !");
            }

            try {
                FIn.close();
                OIn.close();
            } catch (IOException e) {
                System.err.println("Close file false !");
            }
        }
        return null;
    }


}