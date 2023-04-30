package com.example.lutemons;

public class Pink extends Lutemon{
    public Pink () {
        super("Veepee", "Pink", 7, 2, 0, 18, 18);
        image = R.drawable.ic_android_pink_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
    public Pink (String name) {
        super(name, "Pink", 7, 2, 0, 18, 18);
        image = R.drawable.ic_android_pink_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
}
