package com.example.lutemons;

public class Green extends Lutemon{
    public Green () {
        super("Vihris", "Green", 6, 3, 0, 19, 19);
        image = R.drawable.ic_android_green_24dp;
        Home.getInstance().takeLutemonHome(this);
    }

    public Green (String name) {
        super(name, "Green", 6, 3, 0, 19, 19);
        image = R.drawable.ic_android_green_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
}
