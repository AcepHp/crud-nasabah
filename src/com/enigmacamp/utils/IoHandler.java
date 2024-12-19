package com.enigmacamp.utils;

import com.enigmacamp.model.Nasabah;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoHandler {

    public static void checkExistFile(String fileName){
        File file =new File(fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
                System.out.println("File Berhasil Dibuat");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void addFile(List<Nasabah> nasabah, String fileName){
        File file = new File(fileName);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Nasabah nasabahBaru : nasabah){
                String data = nasabahBaru.getId() + "," + nasabahBaru.getFullName() + "," + nasabahBaru.getNik() + "," + nasabahBaru.getPhoneNumber() + "," + nasabahBaru.getBirthDate();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public static void readFile(List<Nasabah> nasabah, String fileName){
        File file = new File(fileName);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data;
            while ((data = bufferedReader.readLine()) != null){
                String[] split = data.split(",");
                Integer id = Integer.parseInt(split[0]);
                nasabah.add(new Nasabah(id, split[1], split[2], split[3], split[4]));
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
