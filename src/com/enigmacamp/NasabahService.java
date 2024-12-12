package com.enigmacamp;


//Untuk memanipulasi data nasabah seperti CRUD Nasabah
public class NasabahService {
    private Nasabah[] items= new Nasabah[5];
    private int nasabahCount = 0;

    public NasabahService(){}

    //Menampilkan Data Nasabah
    public void read(){
        for (int i = 0; i < nasabahCount; i++) {
            if (items[i] != null) {
                System.out.println("ID: " + items[i].getId() + ", Nama: " + items[i].getFullName()+", NIK: "+items[i].getNik()+ ", No HP: "+items[i].getPhoneNumber()+ ", Tanggal Lahir : "+items[i].getBirthDate());
            }
        }
    }

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
    //Update Nasabah
    public void update(int id, Nasabah nasabahBaru){
        try {
            boolean cariData = false;
            for (int i = 0; i < nasabahCount; i++) {
                if (items[i] != null && items[i].getId()==id){
                    if (!isUnik(nasabahBaru.getId(),nasabahBaru.getNik(),nasabahBaru.getPhoneNumber())){
                        throw new Exception("Data Gagal di Update\n");
                    }
                    items[i] = nasabahBaru;
                    System.out.println("Data Berhasil di Update\n");
                    cariData = true;
                    break;
                }
            }
            if (!cariData){
                throw new Exception("Data Tidak Tersedia");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void delete(Integer id){
        try {
            boolean cariData = false;
            Nasabah[] temp = getItems();
            for (int i = 0; i < nasabahCount; i++) {
                if (items[i] != null && items[i].getId()==id){
                    temp[i] = null;
                }
            }
            if (!cariData){
                throw new Exception("Data Tidak Ada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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


}
