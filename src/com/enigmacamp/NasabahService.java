package com.enigmacamp;

import java.util.Arrays;

//Untuk memanipulasi data nasabah seperti CRUD Nasabah
public class NasabahService {
    private Nasabah[] items= new Nasabah[5];
    private int nasabahCount = 0;

    public NasabahService(){}

    //Registrasi Nasabah
    public void create(Nasabah nasabah){
        try {
            if (nasabahCount >= items.length){
                throw new ArrayIndexOutOfBoundsException("Kapasitas Penuh");
            }
            if (!isUnik(nasabah.getId(), nasabah.getNik(), nasabah.getPhoneNumber())){
                throw new Exception("Data sudah tersedia");
            }
            items[nasabahCount] = nasabah;
            nasabahCount++;
            System.out.println("Nasabah Berhasil Ditambahkan");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
//        try {
//            items[nasabahCOunt] = nasabah;
//            System.out.println("Nasabah berhasil ditambahkan");
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e.getMessage());
//        }
    }



    public Nasabah[] getItems() {
        return items;
    }

    private boolean isUnik(int id, String nik, String phoneNUmber){
        for (Nasabah nasabah : items){
            if (nasabah != null){
                if (nasabah.getId()==id || nasabah.getNik().equals(nik) || nasabah.getPhoneNumber().equals(phoneNUmber)){
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public String toString() {
        return "NasabahService{" +
                "items=" + Arrays.toString(items) +
                ", nasabahCount=" + nasabahCount +
                '}';
    }
}
