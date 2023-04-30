package com.example.lutemons;

public abstract class Lutemon {

    protected String name, color;
    protected int attack, defense, experience, health, maxHealth, id, image;
    private static int idCounter = 0;

    public Lutemon() {}

    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = idCounter + 1;

        idCounter++;
    }
    //Getters
    public String getName() {return name;}
    public String getColor() {return color;}
    public int getAttack() {return attack;}
    public int getDefense() {return defense;}
    public int getExperience() {return experience;}
    public int getHealth() {return health;}
    public int getMaxHealth() {return maxHealth;}
    public int getId() {return id;}
    public int getImage() {return image;}

    //Setters
    public void setName(String name) {this.name = name;}
    public void setColor(String color) {this.color = color;}
    public void setAttack(int attack) {this.attack = attack;}
    public void setDefense(int defense) {this.defense = defense;}
    public void setExperience(int experience) {this.experience = experience;}
    public void setHealth(int health) {this.health = health;}
    public void setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;}
    public void setId(int id) {this.id = id;}
    public void setImage(int image) {this.image = image;}
    public int getNumberOfCreatedLutemons() {return idCounter;}
}
