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

        binding.progressBarPetList.setVisibility(View.GONE);
        addPets();

        petAdapter = new PetAdapter(getContext(), pets);
        binding.rvPet.setAdapter(petAdapter);
        binding.rvPet.setHasFixedSize(true);

        return binding.getRoot();
    }

    private void addPets() {
        pets = new ArrayList<>();
        pets.add(new Pet("Kileonmusk", "Hasky", true, 6, 45.5, 111.11, "Red", "gaugau", R.drawable.pet1));
        pets.add(new Pet("Shibaxianua", "Chihuahua", false, 12, 100.2, 150.12, "B&W", "grrrrr", R.drawable.pet2));
        pets.add(new Pet("Hanakem Cheese", "Maddog", false, 3, 15.6, 30.77, "White", "angang", R.drawable.pet3));
        pets.add(new Pet("Betting Helloyboy", "Beandog", true, 2, 140.2, 70.2, "Gray", "ecec", R.drawable.pet4));
        pets.add(new Pet("Brusk", "Cherry", false, 1, 140.2, 70.2, "Orange", "kiiiii", R.drawable.pet5));
        pets.add(new Pet("Kinding", "Calmdog", true, 3, 140.2, 70.2, "Green", "kaka", R.drawable.pet6));
        pets.add(new Pet("Hem", "England Short", true, 4, 140.2, 70.2, "Light Yellow", "hihi", R.drawable.pet2));
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.progressBarPetList.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.progressBarPetList.setVisibility(View.GONE);
    }
}