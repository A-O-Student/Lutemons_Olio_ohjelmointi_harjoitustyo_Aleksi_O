package com.example.lutemons;

import android.annotation.SuppressLint;
import android.widget.TextView;

import java.util.ArrayList;

public class Battlefield {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Battlefield battlefield = null;

    private Battlefield(){}

    public static Battlefield getInstance(){
        if(battlefield == null) {
            battlefield = new Battlefield();
        }
        return battlefield;
    }

    public void takeLutemonToBattlefield(Lutemon lutemon) {
        lutemons.add(lutemon);
        System.out.println(lutemon.getName() + " otettu taistelemaan, muttei turvallisesti!");
    }

    @SuppressLint("SetTextI18n")
    public void makeLutemonsFight(Lutemon lutemon1, Lutemon lutemon2, TextView txtFight) {

        int fightEnded = 0;

        txtFight.setText("A battle between "+ lutemon1.getColor() + "(" + lutemon1.getName() + ") and " + lutemon2.getColor() + "(" + lutemon2.getName() + ") is starting!" + "\n" + "\n");
        while (fightEnded == 0) {
            txtFight.append("1: " + lutemon1.getColor() + "(" + lutemon1.getName() + ") att: " + String.valueOf(lutemon1.getAttack()) + "; def: " + String.valueOf(lutemon1.getDefense()) + "; exp: " + String.valueOf(lutemon1.getExperience()) + "; health: " + String.valueOf(lutemon1.getHealth()) + "/" + String.valueOf(lutemon1.getMaxHealth())+ "\n" + "\n");
            txtFight.append("2: " + lutemon2.getColor() + "(" + lutemon2.getName() + ") att: " + String.valueOf(lutemon2.getAttack()) + "; def: " + String.valueOf(lutemon2.getDefense()) + "; exp: " + String.valueOf(lutemon2.getExperience()) + "; health: " + String.valueOf(lutemon2.getHealth()) + "/" + String.valueOf(lutemon2.getMaxHealth())+ "\n" + "\n");
            txtFight.append(lutemon1.getColor() + "(" + lutemon1.getName() + ") attacks " + lutemon2.getColor() + "(" + lutemon2.getName() + ")"+ "\n" + "\n");
            lutemon2.setHealth(lutemon2.getHealth()-lutemon1.getAttack()-lutemon1.getExperience()+lutemon2.getDefense());
            if (lutemon2.getHealth() > 0) {
                txtFight.append(lutemon2.getColor() + "(" + lutemon2.getName() + ") manages to espace death."+ "\n" + "\n");
                Lutemon templut = lutemon1;
                lutemon1 = lutemon2;
                lutemon2 = templut;
            } else {
                txtFight.append(lutemon2.getColor() + "(" + lutemon2.getName() + ") gets killed."+ "\n" + "\n");
                txtFight.append("The battle is over."+ "\n" + "\n");
                fightEnded = 1;
                lutemon1.setExperience(lutemon1.getExperience() + 1);
                Storage.getInstance().removeLutemon(lutemon2);
                Battlefield.getInstance().moveLutemonFromBattlefield(lutemon2);
            }
        }
    }

    public void moveLutemonFromBattlefield(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {return lutemons;}

    public Lutemon getLutemonById(int id) { return lutemons.get(id);}

}
