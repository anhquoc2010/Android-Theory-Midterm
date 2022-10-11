package com.example.midterm_android.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midterm_android.model.Pet;
import com.example.midterm_android.adapter.PetAdapter;
import com.example.midterm_android.R;
import com.example.midterm_android.databinding.FragmentPetsListBinding;

import java.util.ArrayList;

public class PetsListFragment extends Fragment {

    private FragmentPetsListBinding binding;
    private ArrayList<Pet> pets;
    private PetAdapter petAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPetsListBinding.inflate(inflater, container, false);

        addPets();

        petAdapter = new PetAdapter(getContext(), pets);
        binding.rvPet.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.rvPet.setAdapter(petAdapter);

        return binding.getRoot();
    }

    private void addPets() {
        pets = new ArrayList<>();
        pets.add(new Pet("Trần Đức Mạnh", "Hasky", true, 6, 45.5, 111.11, "Red", "hehe", R.drawable.pet1));
        pets.add(new Pet("Huỳnh Tấn Lực", "Chihuahua", true, 12, 100.2, 150.12, "B&W", "hoho", R.drawable.pet2));
        pets.add(new Pet("Trần Thị Kim Ngân", "Maddog", false, 3, 15.6, 30.77, "White", "huhu", R.drawable.pet3));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
    }
}