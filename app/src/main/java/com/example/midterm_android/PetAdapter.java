package com.example.midterm_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Pet> petsList;

    public PetAdapter(Context context, ArrayList<Pet> petsList) {
        this.context = context;
        this.petsList = petsList;
    }

    @NonNull
    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Gán View
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapter.ViewHolder holder, int position) {
        // Gán dữ liệu
        Pet pet = petsList.get(position);

        holder.tvName.setText(pet.getName());
        holder.tvSpecies.setText(pet.getSpecies());
        holder.tvColor.setText(pet.getColor());
        holder.tvAge.setText(String.valueOf(pet.getAge()));
        holder.ivAvatar.setImageResource(pet.getImageResourceID());
    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvSpecies;
        TextView tvColor;
        TextView tvAge;
        ImageView ivAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
            tvSpecies = itemView.findViewById(R.id.tv_species);
            tvColor = itemView.findViewById(R.id.tv_color);
            tvAge = itemView.findViewById(R.id.tv_age);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
        }
    }
}
