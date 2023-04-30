package com.example.lutemons;

public class Orange extends Lutemon{
    public Orange () {
        super("Appelsiini", "Orange", 8, 1, 0, 17, 17);
        image = R.drawable.ic_android_orange_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
    public Orange (String name) {
        super(name, "Orange", 8, 1, 0, 17, 17);
        image = R.drawable.ic_android_orange_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
}
