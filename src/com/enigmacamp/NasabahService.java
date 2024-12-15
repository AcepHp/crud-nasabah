package com.enigmacamp;


import java.util.Arrays;

//Untuk memanipulasi data nasabah seperti CRUD Nasabah
public class NasabahService implements NasabahInterface{
    private Nasabah[] items= new Nasabah[15];

    private int nasabahCount = 0;

    public NasabahService(){}

    //Menampilkan Data Nasabah
    public Nasabah[] read() {
        Nasabah[] result = new Nasabah[this.items.length];

        Integer index = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items != null){
                result[index++] = this.items[i];
            }
        }
        return result;
    }

    public Nasabah readById(int id){
        Nasabah result = null;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null){
                if (this.items[i].getId() == id){
                    result = this.items[i];
                    break;
                }
            }

        }
        if(result != null){
            return result;
        } else {
            throw new NasabahException("Data tidak ditemukan");
        }
    }

    //Registrasi Nasabah
    public void create(Nasabah nasabah){

            //Validasi array belum penuh
            if (this.nasabahCount >= this.items.length){
                throw new ArrayIndexOutOfBoundsException("Kapasitas Penuh");
            }
            //Validasi unique id, nik, phoneNumbe
            if (!isUnik(nasabah.getId(), nasabah.getNik(), nasabah.getPhoneNumber())){
                throw new NasabahException("Data sudah tersedia");
            }
            //
            this.items[this.nasabahCount] = nasabah;
            this.nasabahCount++;
            System.out.println("Nasabah Berhasil Ditambahkan");

    }

    //Update Nasabah
    public void update(int id, Nasabah nasabahBaru){

        boolean cariData = false;
        for (int i = 0; i < this.nasabahCount; i++) {
            if (this.items[i] != null && this.items[i].getId()==id){
                if (!isUnik(nasabahBaru.getId(),nasabahBaru.getNik(),nasabahBaru.getPhoneNumber())){
                    throw new NasabahException("Data Sudah ada, Gagal Update\n");
                }
                this.items[i] = nasabahBaru;
                System.out.println("Data Berhasil di Update\n");
                cariData = true;
                break;
            }
        }
        if (!cariData){
            throw new NasabahException("Data Tidak Tersedia");
        }

    }

    public void delete(Integer id){

        //membuat variable untuk mencari data
        boolean cariData = false;
        // Mendapatkan array this.items yang berisi data Nasabah
        Nasabah[] temp = getItems();
        for (int i = 0; i < this.nasabahCount; i++) {
            // cek data tidak null, cek id nasabah cocok dengan yg diari
            if (this.items[i] != null && this.items[i].getId()==id){
                //mengubah data menjadi null
                temp[i] = null;
                System.out.println("Data Berhasil Dihapus");
                cariData = true;
            }
        }
        if (!cariData){
            throw new NasabahException("Data Tidak Ada");
        }

    }


    @Override
    public String toString() {
        return "NasabahService{" +
                "items=" + Arrays.toString(this.items) +
                ", nasabahCount=" + this.nasabahCount +
                '}';
    }



    public Nasabah[] getItems() {
        return this.items;
    }

    private boolean isUnik(int id, String nik, String phoneNUmber){
        for (Nasabah nasabah : this.items){
            if (nasabah != null){
                if (nasabah.getId()==id || nasabah.getNik().equals(nik) || nasabah.getPhoneNumber().equals(phoneNUmber)){
                    return false;
                }
            }

        }
        return true;
    }

}
