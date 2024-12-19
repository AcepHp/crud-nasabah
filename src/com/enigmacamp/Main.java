package com.enigmacamp;

import com.enigmacamp.model.Nasabah;
import com.enigmacamp.service.NasabahService;
import com.enigmacamp.utils.InputHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NasabahService service = new NasabahService();
        InputHandler input = new InputHandler(new Scanner(System.in));

//        Nasabah newNasabah = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
//        Nasabah newNasabah2 = new Nasabah(2, "Jaja", "12345678900", "0823322340", "2009-01-01");
//        Nasabah newNasabah3 = new Nasabah(3, "Ucup", "12345678901", "0823322341", "2009-01-01");
//        Nasabah newNasabah4 = new Nasabah(4, "Jeje", "12345678902", "0823322342", "2009-01-01");
//        Nasabah newNasabah5 = new Nasabah(5, "Nana", "12345678903", "0823322343", "2009-01-01");
//
//        service.create(newNasabah);
//        service.create(newNasabah2);
//        service.create(newNasabah3);
//        service.create(newNasabah4);
//        service.create(newNasabah5);

            while (true){
                System.out.println("========== Menu Nasabah ==========");
                System.out.println("1. Lihat Data");
                System.out.println("2. Tambah Data");
                System.out.println("3. Update Data");
                System.out.println("4. Hapus Data");
                System.out.println("5. Keluar");
                int pilih = input.GetInt("Masukkan Angka 1-4 : ");
                switch (pilih){
                    case 1 :
                        System.out.println("Data Nasabah : ");
                        service.read();
                        break;
                    case 2:
                        try {
                            int id = input.GetInt("Input ID : ");
                            String fullName = input.getString("Input FullName : ");
                            String nik = input.getString("Input NIK : ");
                            String phoneNumber = input.getString("Input No.HP :");
                            String birthDate = input.getString("Input Birth Date :");

                            Nasabah nasabah = new Nasabah(id,fullName, nik, phoneNumber,birthDate);

                            service.create(nasabah);

                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            int idUpdate = input.GetInt("Input ID Yang Mau di Edit :");
                            String fullNameUpdate = input.getString("Input FullName : ");
                            String nikUpdate = input.getString("Input NIK : ");
                            String phoneNumberUpdate = input.getString("Input No.HP :");
                            String birthDateUpdate = input.getString("Input Birth Date :");

                            Nasabah nasabahBaru = new Nasabah( fullNameUpdate, nikUpdate, phoneNumberUpdate, birthDateUpdate);

                            service.update(idUpdate, nasabahBaru);
                            break;
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
//                        service.delete();
                        int id3 = input.GetInt("Input ID Yang akan dihapus : ");
                        service.delete(id3);
                        break;
                    case 5:
                        System.out.println("Keluar Dari Aplikasi");
                        return;
                    default:
                        System.out.println("Pilihan Tidak Tersedia");
                        break;
                }

            }
//


    }

//    public static void main(String[] args) {
        // Data Nasabah
//            Nasabah newNasabah = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
//            Nasabah newNasabah2 = new Nasabah(2, "Jaja", "12345678900", "0823322340", "2009-01-01");
//            Nasabah newNasabah3 = new Nasabah(3, "Ucup", "12345678901", "0823322341", "2009-01-01");
//            Nasabah newNasabah4 = new Nasabah(4, "Jeje", "12345678902", "0823322342", "2009-01-01");
//            Nasabah newNasabah5 = new Nasabah(5, "Nana", "12345678903", "0823322343", "2009-01-01");
//
//            NasabahService service = new NasabahService();
//
//            // Tambah Data Nasabah
//            service.create(newNasabah);
//            service.create(newNasabah2);
//            service.create(newNasabah3);
//            service.create(newNasabah4);
//            service.create(newNasabah5);
//
//            // Menampilkan Data
//            System.out.println("\nData Nasabah : ");
//            service.read();
//
//            //Update Data
//            Nasabah updateNasabah = new Nasabah("Acep", "123456231323", "08332167554", "2001-09-01");
//            service.update(1,updateNasabah);
//            service.read();
//
//            //Menghapus Data
//            service.delete(3);
//
//            service.read();
//    }
//    public static void main(String[] args) {


//        try {
//            Nasabah newNasabah = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
//            Nasabah newNasabah2 = new Nasabah(2, "Juan2", "12345678900", "0823322340", "2009-01-01");
//            Nasabah newNasabah3 = new Nasabah(3, "Juan3", "12345678901", "0823322341", "2009-01-01");
//            Nasabah newNasabah4 = new Nasabah(4, "Juan4", "12345678902", "0823322342", "2009-01-01");
//            Nasabah newNasabah5 = new Nasabah(5, "Juan5", "12345678903", "0823322343", "2009-01-01");
//            Nasabah newNasabah6 = new Nasabah(6, "Juan6", "12345678904", "0823322344", "2009-01-01");
//            Nasabah newNasabah7 = new Nasabah(7, "Juan7", "12345678905", "0823322345", "2009-01-01");
//            Nasabah newNasabah8 = new Nasabah(8, "Juan8", "12345678908", "0823322346", "2009-01-01");
//            Nasabah newNasabah9 = new Nasabah(9, "Juan9", "12345678909", "0823322347", "2009-01-01");
//            Nasabah newNasabah10 = new Nasabah(10, "Juan10", "12345678910", "0823322348", "2009-01-01");
//            Nasabah newNasabah11 = new Nasabah(11, "Juan11", "12345678911", "0823322349", "2009-01-01");
//            Nasabah newNasabah12 = new Nasabah(12, "Juan12", "12345678912", "0823322310", "2009-01-01");
//            Nasabah newNasabah13 = new Nasabah(13, "Juan13", "12345678913", "0823322311", "2009-01-01");
//            Nasabah newNasabah14 = new Nasabah(14, "Juan14", "12345678914", "0823322312", "2009-01-01");
////            Nasabah newNasabah15 = new Nasabah(15, "Juan15", "12345678915", "0823322313", "2009-01-01");
////            Nasabah newNasabah16 = new Nasabah(16, "Juan16", "12345678916", "0823322314", "2009-01-01");
//
//
//            NasabahService service = new NasabahService();
//
//
//            //--------CREATE
//            service.create(newNasabah);
//            service.create(newNasabah2);
//            service.create(newNasabah3);
//            service.create(newNasabah4);
//            service.create(newNasabah5);
//            service.create(newNasabah6);
//            service.create(newNasabah7);
//            service.create(newNasabah8);
//            service.create(newNasabah9);
//            service.create(newNasabah10);
//            service.create(newNasabah11);
//            service.create(newNasabah12);
//            service.create(newNasabah13);
//            service.create(newNasabah14);
////            service.create(newNasabah15);
////            service.create(newNasabah16);
//
//            //---------Read
////            readArray(service.read());
//
//            System.out.println("Cek Id : " +service.readById(1));
//
//            //---------Update
//            Nasabah updateNasabah = new Nasabah(20, "Acep", "123456231323", "08332167554", "2001-09-01");
//            service.update(1, updateNasabah);
//
//            //----------Read
////            readArray(service.read());
//
//            //----------Delete
////        service.delete(9);
//
//            //----------Read
////        service.read();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }



//    }


//    static void readArray(Nasabah[] result) {
//        for (int i = 0; i < result.length ; i++) {
//            System.out.println("Data ke " + (i+1) + ": " + result[i]);
//        }
//    }

    // 1. Lengkapi service CRUD (Create, Read, Update, dan Delete)
    // 2. Implementasikan sebuah Exception untuk validasi berikut :
    //  a. Validasi jika data sudah penuh
    //  b. Validasi jika data tidak ada ketika melakukan (update, delete, dan get by id)
    //  c. Validasi jika id, nik dan phone number sudah ada, artinya harus unique
    // 3. Buatlah branch baru dengan nama 02-use-interface dan gunakanlah interface/contract untuk CRUD service
    // 4. Buatlah commit per fitur
    //   contoh :
    //  - feat : create nasabah
    //  - feat : update nasabah
    //  - fix : unique attribute validation when create date
}