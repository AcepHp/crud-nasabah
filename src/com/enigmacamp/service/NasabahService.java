package com.enigmacamp.service;


import com.enigmacamp.model.Nasabah;
import com.enigmacamp.utils.IoHandler;
import com.enigmacamp.utils.NasabahException;

import java.util.ArrayList;

//Untuk memanipulasi data nasabah seperti CRUD Nasabah
public class NasabahService implements NasabahInterface {

    private ArrayList<Nasabah> items = new ArrayList<>();
    String fileName = "data.txt";

//    private Nasabah[] items= new Nasabah[15];

//    private int nasabahCount = 0;

    public NasabahService(ArrayList<Nasabah> items, String fileName) {
        this.items = items;
        this.fileName = fileName;
    }

    public NasabahService() {
        IoHandler.checkExistFile(fileName);
        IoHandler.readFile(items, fileName);
    }

    public void read() {
        for (Nasabah item : items) {
            System.out.println(item);
        }
    }

    public Nasabah readById(int id) {
        for (Nasabah nasabah : this.items) {
            if (nasabah != null && nasabah.getId() == id) {
                return nasabah;
            }
        }
        throw new NasabahException("Data Tidak Ditemukan");
    }


    public void create(Nasabah nasabah) {
        if (isUnik(nasabah.getId(), nasabah.getNik(), nasabah.getPhoneNumber())){
            this.items.add(nasabah);
            IoHandler.addFile(items, fileName);
            System.out.println("Nasabah " +nasabah+ nasabah.getFullName()+ "Berhasil Ditambahkan");
            System.out.println();
//            System.out.println("Data Berhasil Ditambahkan");
        }
    }

    public void update(int id, Nasabah nasabahBaru) {
        boolean cariData = false;
        for (Nasabah nasabah : items) {
            if (nasabah != null && nasabah.getId() == id) {
                cariData = true;
                if (isUnik(nasabahBaru.getId(), nasabahBaru.getNik(), nasabahBaru.getPhoneNumber())) {
                    nasabah.setFullName(nasabahBaru.getFullName());
                    nasabah.setNik(nasabahBaru.getNik());
                    nasabah.setPhoneNumber(nasabahBaru.getPhoneNumber());
                    nasabah.setBirthDate(nasabahBaru.getBirthDate());
                    nasabah.setFullName(nasabahBaru.getFullName());
                    System.out.println("\nData Berhasil di Update");
                    IoHandler.addFile(items, fileName);
                } else {
                    throw new NasabahException("Data Tidak Unik, Gagal Update");
                }
                break;
            }
        }if(!cariData){
            throw new NasabahException("Data Tidak DItemukan");
        }
    }

//        for (int i = 0; i < this.nasabahCount; i++) {
//            if (this.items[i] != null && this.items[i].getId()==id){
//                if (!isUnik(nasabahBaru.getId(),nasabahBaru.getNik(),nasabahBaru.getPhoneNumber())){
//                    throw new NasabahException("Data Sudah ada, Gagal Update\n");
//                }
//                this.items[i] = nasabahBaru;
//                System.out.println("Data Berhasil di Update\n");
//                cariData = true;
//                break;
//            }
//        }
//        if (!cariData){
//            throw new NasabahException("Data Tidak Tersedia");
//        }


    @Override
    public void delete(Integer id) {
        boolean terhapus;
        for (Nasabah nasabah : this.items){
            if (nasabah != null && nasabah.getId() == id){
                this.items.remove(nasabah);
                System.out.println("\nData Berhasil Dihapus");
                terhapus = true;
                IoHandler.addFile(items, fileName);
                break;
            }
        }
        if (terhapus = false){
            throw new NasabahException("\nData Gagal Dihapus");
        }
    }

//    @Override
//    public Nasabah[] getItems() {
//        return new Nasabah[0];
//    }
    public ArrayList<Nasabah> getItems() {
        return items;
    }

    private boolean isUnik(int id, String nik, String phoneNUmber) {
        for (Nasabah nasabah : this.items) {
            if (nasabah != null) {
//                if (nasabah.getId() == id || nasabah.getNik().equals(nik) || nasabah.getPhoneNumber().equals(phoneNUmber)) {
//                    return false;
//                }
                if (nasabah.getId() == id){
                    throw new NasabahException("Data ID Sudah Ada");
                } else if (nasabah.getNik() == nik) {
                    throw new NasabahException("Data NIK Sudah Ada");
                } else if (nasabah.getPhoneNumber() == phoneNUmber) {
                    throw new NasabahException("Data Phone Number Sudah Ada");
                }
            }

        }
        return true;
    }
}


// Read Data I/O



//    @Override
//    public Nasabah getItems() {
//        return new Nasabah[0];
//    }

//        Integer index = 0;
//        for (int i = 0; i < this.items.length; i++) {
//            if (this.items != null){
//                result[index++] = this.items[i];
//            }
//        }
//        return result;
//        return null;
//    }


//        for (int i = 0; i < this.items; i++) {
//            if (this.items[i] != null){
//                if (this.items[i].getId() == id){
//                    result = this.items[i];
//                    break;
//                }
//            }
//
//        }
//        if(result != null){
//            return result;
//        } else {
//            throw new NasabahException("Data tidak ditemukan");
//        }
//    }

    //Registrasi Nasabah
//    public void create(Nasabah nasabah){
//
//
//            //Validasi array belum penuh
//            if (this.nasabahCount >= this.items.length){
//                throw new ArrayIndexOutOfBoundsException("Kapasitas Penuh");
//            }
//            //Validasi unique id, nik, phoneNumbe
//            if (!isUnik(nasabah.getId(), nasabah.getNik(), nasabah.getPhoneNumber())){
//                throw new NasabahException("Data sudah tersedia");
//            }
//            //
//            this.items[this.nasabahCount] = nasabah;
//            this.nasabahCount++;
//            System.out.println("Nasabah Berhasil Ditambahkan");
//
//    }

    //Update Nasabah
//    public void update(int id, Nasabah nasabahBaru){
//
//        boolean cariData = false;
//        for (int i = 0; i < this.nasabahCount; i++) {
//            if (this.items[i] != null && this.items[i].getId()==id){
//                if (!isUnik(nasabahBaru.getId(),nasabahBaru.getNik(),nasabahBaru.getPhoneNumber())){
//                    throw new NasabahException("Data Sudah ada, Gagal Update\n");
//                }
//                this.items[i] = nasabahBaru;
//                System.out.println("Data Berhasil di Update\n");
//                cariData = true;
//                break;
//            }
//        }
//        if (!cariData){
//            throw new NasabahException("Data Tidak Tersedia");
//        }
//
//    }

//    public void delete(Integer id){
//
//        //membuat variable untuk mencari data
//        boolean cariData = false;
//        // Mendapatkan array this.items yang berisi data Nasabah
//        Nasabah[] temp = getItems();
//        for (int i = 0; i < this.nasabahCount; i++) {
//            // cek data tidak null, cek id nasabah cocok dengan yg diari
//            if (this.items[i] != null && this.items[i].getId()==id){
//                //mengubah data menjadi null
//                temp[i] = null;
//                System.out.println("Data Berhasil Dihapus");
//                cariData = true;
//            }
//        }
//        if (!cariData){
//            throw new NasabahException("Data Tidak Ada");
//        }
//
//    }


//    @Override
//    public String toString() {
//        return "NasabahService{" +
//                "items=" + Arrays.toString(this.items) +
//                ", nasabahCount=" + this.nasabahCount +
//                '}';
//    }
//
//
//
//    public Nasabah[] getItems() {
//        return this.items;
//    }
//
//    private boolean isUnik(int id, String nik, String phoneNUmber){
//        for (Nasabah nasabah : this.items){
//            if (nasabah != null){
//                if (nasabah.getId()==id || nasabah.getNik().equals(nik) || nasabah.getPhoneNumber().equals(phoneNUmber)){
//                    return false;
//                }
//            }
//
//        }
//        return true;
