package com.example.lutemons;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;

    private Storage(){}

    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {return lutemons;}

    public void addLutemon(Lutemon lutemon) {lutemons.add(lutemon);}

    public void removeLutemon(Lutemon lutemon) {lutemons.remove(lutemon);}

    public Lutemon getLutemonById(int id) { return lutemons.get(id);}

}
