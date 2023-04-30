package com.example.lutemons;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage;
    TextView nameandcolor, attack, defense, health, experience;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ivLutemonImage);
        nameandcolor = itemView.findViewById(R.id.tvNameAndColor);
        attack = itemView.findViewById(R.id.tvAttack);
        defense = itemView.findViewById(R.id.tvDefense);
        health = itemView.findViewById(R.id.tvHealth);
        experience = itemView.findViewById(R.id.tvExperience);
    }
}
