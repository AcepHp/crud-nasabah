package com.enigmacamp.service;

import com.enigmacamp.model.Nasabah;

public interface NasabahInterface {
    void read();
    void create(Nasabah nasabah);
    void update(int id, Nasabah nasabahBaru);
    void delete(Integer id);
    Nasabah[] getItems();
}
