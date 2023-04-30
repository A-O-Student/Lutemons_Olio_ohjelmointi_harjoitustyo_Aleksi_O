package com.example.lutemons;

import java.util.ArrayList;

public class Home {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Home home = null;

    private Home(){}

    public static Home getInstance(){
        if(home == null) {
            home = new Home();
        }
        return home;
    }

    public void takeLutemonHome(Lutemon lutemon) {
        lutemons.add(lutemon);
        setHealthToMax(lutemon);
        System.out.println(lutemon.getName() + " otettu kotia turvallisesti!");
    }

    private void setHealthToMax(Lutemon lutemon) {
        lutemon.setHealth(lutemon.getMaxHealth());
    }

    public void moveLutemonFromHome(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    public Lutemon getLutemonById(int id) { return lutemons.get(id);}
    public ArrayList<Lutemon> getLutemons() {return lutemons;}

}
