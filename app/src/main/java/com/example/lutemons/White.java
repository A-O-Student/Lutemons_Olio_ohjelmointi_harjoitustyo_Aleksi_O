package com.example.lutemons;

public class White extends Lutemon{

    public White () {
        super("Valkku", "White", 5, 4, 0, 20, 20);
        image = R.drawable.ic_android_white_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
    public White (String name) {
        super(name, "White", 5, 4, 0, 20, 20);
        image = R.drawable.ic_android_white_24dp;
        Home.getInstance().takeLutemonHome(this);
    }

}
