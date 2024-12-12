package com.enigmacamp;

public interface NasabahInterface {
    public void read();
    public void create(Nasabah nasabah);
    public void update(int id, Nasabah nasabahBaru);
    public void delete(Integer id);
    public Nasabah[] getItems();
}
