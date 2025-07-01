package com.enigmacamp;

public interface NasabahInterface {
    Nasabah[] read();
    void create(Nasabah nasabah);
    void update(int id, Nasabah nasabahBaru);
    void delete(Integer id);
    Nasabah[] getItems();
}
