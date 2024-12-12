package com.enigmacamp;

//Untuk memanipulasi data nasabah seperti CRUD Nasabah
public class NasabahService {
    private Nasabah[] items= new Nasabah[15];
    private int nasabahCOunt = 0;

    public NasabahService(){}

    //Registrasi Nasabah
    public void create(Nasabah nasabah){
        items[nasabahCOunt] = nasabah;
        System.out.println("Nasabah berhasil ditambahkan");
    }

    public Nasabah[] getItems() {
        return items;
    }
}
