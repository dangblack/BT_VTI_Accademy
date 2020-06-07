package Backend.Exercise3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Exercise 3: Build class FileManagement
 */
public class FileManagement {
    static ArrayList<String> fileNames = new ArrayList<String>();

    //Check file is exists
    public static boolean CheckFileIsExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    // Create file
    public static void createFile(String pathFile) throws Exception {
        if (CheckFileIsExists(pathFile)) {
            throw new Exception("File is exits !");
        } else {
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("Create file success !");
            } else {
                System.err.println("Create file false !");
            }
        }
    }

    //Delete file
    public static void deleteFile(String pathFile) throws Exception {
        File file = new File(pathFile);
        if (CheckFileIsExists(pathFile)) {
            if (file.delete()) {
                System.out.println("Delete file success !");
            } else {
                System.out.println("Delete file false !");
            }
        } else {
            throw new Exception("Error! File Not Exist.");
        }
    }

    // Check path is File or Folder
    public static boolean isFolder(String pathFile) {
        File file = new File(pathFile);
        if (file.isDirectory()) {
            System.out.println("Path is folder");
            return true;
        } else {
            System.out.println("Path is file");
            return false;
        }
    }

    //Get all file name of folder
    public static ArrayList<String> getAllFileName(String pathFile) throws Exception {
        File file = new File(pathFile);
        if (isFolder(pathFile)) {
            for (String fileName : file.list()) {
                fileNames.add(fileName);
            }
        } else {
            throw new Exception("Error! Path is not folder.");
        }
        System.out.println(fileNames);
        return fileNames;
    }

    //Copy File
    public static void copyFile(String pathOldFile, String newPath) throws Exception {


        if (CheckFileIsExists(pathOldFile)) {
            File source = new File(pathOldFile);
            File dest = new File(newPath);
            Files.copy(source.toPath(), dest.toPath());
        } else {
            throw new Exception("Error! File Not Exist.");
        }
    }

    public static void copyFile(String pathOldFile, String newPath, String newName) throws Exception {
        if (CheckFileIsExists(pathOldFile)) {
            File source = new File(pathOldFile);
            File dest = new File(newPath);
            File newFile = new File(newName);
            Files.copy(source.toPath(), dest.toPath());
            dest.renameTo(newFile);
        } else {
            throw new Exception("Error! File Not Exist.");
        }
    }

    //Moving file
    public static void moveFile(String pathOldFile, String newPath) throws Exception {
        if (CheckFileIsExists(pathOldFile)) {
            File source = new File(pathOldFile);
            File dest = new File(newPath);
            Files.move(source.toPath(), dest.toPath());
            deleteFile(pathOldFile);
        } else {
            throw new Exception("Error! File Not Exist.");
        }
    }

    //Rename File
    public static void renameFile(String pathOldFile, String newName) throws Exception {

        File old = new File(pathOldFile);
        File newFile = new File(newName);
        if (!CheckFileIsExists(pathOldFile)) {
            throw new Exception("Error! File Not Exist.");
        } else if (CheckFileIsExists(newName)) {
            throw new Exception("Error! Name is Exist.");
        } else {
            old.renameTo(newFile);
        }
    }

    //Create New Folder
    public static void createNewFolder(String newPathFolder) throws Exception {
        File folder = new File(newPathFolder);
        if (folder.exists()) {
            throw new Exception("Error! Folder Exist.");
        } else {
            folder.mkdir();
        }
    }

    //Download file
    public static void downloadFile(String fileLink, String pathFolder) throws Exception {
        File folder1 = new File(pathFolder);
        if (!folder1.exists() || !folder1.isDirectory()) {
            System.out.println("Error!Folder is not exist or not folder.");
        }
        String s[] = fileLink.split("/");
        String name = s[s.length - 1];
        pathFolder = pathFolder + "/" + name;
        //connect to URL
        URL url = new URL(fileLink);
        URLConnection connection = url.openConnection();
        //get size of file
        int size = connection.getContentLength();
        //read file from internet
        InputStream in = connection.getInputStream();
        //save file
        FileOutputStream output = new FileOutputStream(pathFolder);
        int byteDownload = 0;
        byte[] b = new byte[1024];
        //get length
        int length = in.read(b);
        while (length != -1) {
            byteDownload += length;
            System.out.println(byteDownload * 100f / size + "%");
            //write content downloaded from 0 -> length to ouput
            output.write(b, 0, length);
            length = in.read(b);
        }

        //close
        output.close();
        in.close();
        System.out.println("Download success");

    }
}
