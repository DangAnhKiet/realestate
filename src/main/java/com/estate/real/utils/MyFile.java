package com.estate.real.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFile {

    public static final String ADDRESS_CONTRACT_FILE = "addressContract.txt";
    public static final String ADDRESS_CONTRACT_SEND = "addressContractSend.txt";
    public static final String ADDRESS_CONTRACT_RECEIVE = "addressContractReceive.txt";

    public static boolean CreateNewFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Tao file thanh cong");
                return true;
            } else {
                System.out.println("File da ton tai.");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Loi tao file");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean WriteToFile(String fileName, String content) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Ghi file thanh cong");
            return true;
        } catch (Exception e) {
            System.out.println("Loi ghi file");
            e.printStackTrace();
            return false;
        }
    }

    public static String RealFromFile(String fileName) {
        String strResult = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                strResult = myReader.nextLine();
            }
            System.out.println("Doc file thanh cong");
        } catch (Exception e) {
            System.out.println("Loi doc file");
            e.printStackTrace();
            strResult = "0x0000";
        }
        return strResult;
    }

    public static void main(String[] args) {
//        System.out.println(CreateNewFile(MyFile.ADDRESS_CONTRACT_FILE));
//        System.out.println(WriteToFile(MyFile.ADDRESS_CONTRACT_FILE,"hau2"));
    }
}
