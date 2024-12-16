package com.enigmacamp;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    //Input Number atau Input String;
    public int GetInt(String prompt){ //Input price, data will be calculate in the future
        System.out.print(prompt);
        //Lakukan Validasi karena input harus berupa angka
        while (!scanner.hasNextInt()){
            System.out.println("Input Harus Berupa Angka !");
            scanner.next();
            System.out.print(prompt);
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public String getString(String prompt){
        System.out.print(prompt);
        String result = scanner.nextLine();

        while (result.trim().isEmpty()){
            System.out.println("Tidak Boleh Kosong");
            System.out.print(prompt);
            result = scanner.nextLine();
        }
        return result;
    }
}
