package com.enigmacamp;

public class Main {
    public static void main(String[] args) {
        Nasabah newNasabah = new Nasabah(1, "Juan", "1234567890", "082332234", "2009-01-01");
        NasabahService service = new NasabahService();

        service.create(newNasabah);

        for (Nasabah nasabah : service.getItems()){
            if (nasabah != null) System.out.println(nasabah);
        }
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