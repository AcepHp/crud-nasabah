package com.enigmacamp;

public class Main {
    public static void main(String[] args) {
        Nasabah newNasabah = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
        Nasabah newNasabah2 = new Nasabah(2, "Juan", "12345678900", "0823322340", "2009-01-01");
        Nasabah newNasabah3 = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
        Nasabah newNasabah4 = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
        Nasabah newNasabah5 = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
        Nasabah newNasabah6 = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");


        NasabahService service = new NasabahService();

        //--------CREATE
        service.create(newNasabah);
        service.create(newNasabah2);
        service.create(newNasabah3);
        service.create(newNasabah4);
        service.create(newNasabah5);
        service.create(newNasabah6);

        Nasabah updateNasabah = new Nasabah(3, "Acep", "1212121212", "082316167554", "2001-09-01");
        service.update(1, updateNasabah);



    }

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