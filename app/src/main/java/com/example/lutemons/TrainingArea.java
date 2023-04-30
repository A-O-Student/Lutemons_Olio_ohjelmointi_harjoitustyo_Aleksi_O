package com.example.lutemons;

import java.util.ArrayList;

public class TrainingArea {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static TrainingArea trainingarea = null;

    private TrainingArea(){}

    public static TrainingArea getInstance(){
        if(trainingarea == null) {
            trainingarea = new TrainingArea();
        }
        return trainingarea;
    }

    public void takeLutemonTraining(Lutemon lutemon) {lutemons.add(lutemon);}
    public void moveLutemonFromTraining(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }
    public ArrayList<Lutemon> getLutemons() {return lutemons;}
    public Lutemon getLutemonById(int id) { return lutemons.get(id);}
    public void trainLutemon(Lutemon lutemon) {
        lutemon.setExperience(lutemon.getExperience()+1);
    }
}
