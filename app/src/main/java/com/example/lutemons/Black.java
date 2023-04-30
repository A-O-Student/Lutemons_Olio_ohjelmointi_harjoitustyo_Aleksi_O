package com.example.lutemons;

public class Black extends Lutemon{
    public Black () {
        super("Mustis", "Black", 9, 0, 0, 16, 16);
        image = R.drawable.ic_android_black_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
    public Black (String name) {
        super(name, "Black", 9, 0, 0, 16, 16);
        image = R.drawable.ic_android_black_24dp;
        Home.getInstance().takeLutemonHome(this);
    }
}
