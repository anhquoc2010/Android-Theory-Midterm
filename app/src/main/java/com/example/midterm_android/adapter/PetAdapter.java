package com.example.midterm_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm_android.model.Pet;
import com.example.midterm_android.R;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Pet> petsList;

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
        if (pet.isGender()) {
            holder.ivGender.setImageResource(R.drawable.male_black_24dp);
        } else {
            holder.ivGender.setImageResource(R.drawable.female_black_24dp);
        }
        holder.ivAvatar.setImageResource(pet.getImageResourceID());
    }

    @Override
    public int getItemCount() {
        if (petsList != null) {
            return petsList.size();
        } else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvSpecies;
        TextView tvColor;
        TextView tvAge;
        ImageView ivGender;
        ImageView ivAvatar;

        ImageView ivMark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            tvName = itemView.findViewById(R.id.tv_name);
            tvSpecies = itemView.findViewById(R.id.tv_species);
            tvColor = itemView.findViewById(R.id.tv_color);
            tvAge = itemView.findViewById(R.id.tv_age);
            ivGender = itemView.findViewById(R.id.iv_gender);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);

            ivMark = itemView.findViewById(R.id.iv_mark);
            ivMark.setTag("unmarked");
            ivMark.setOnClickListener(v -> {
                if (ivMark.getTag().equals("unmarked")) {
                    ivMark.setImageResource(R.drawable.favorite_black_36dp);
                    ivMark.setTag("marked");
                } else {
                    ivMark.setImageResource(R.drawable.favorite_border_black_36dp);
                    ivMark.setTag("unmarked");
                }
            });
        }
    }
}
