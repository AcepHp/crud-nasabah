package com.enigmacamp.service;

import com.enigmacamp.model.Nasabah;

import java.util.ArrayList;

public interface NasabahInterface {
    void read();
    void create(Nasabah nasabah);
    void update(int id, Nasabah nasabahBaru);
    void delete(Integer id);
    ArrayList<Nasabah> getItems();
}
