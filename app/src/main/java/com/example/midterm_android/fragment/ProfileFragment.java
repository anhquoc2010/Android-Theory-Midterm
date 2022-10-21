package com.example.midterm_android.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midterm_android.MainActivity;
import com.example.midterm_android.R;
import com.example.midterm_android.adapter.GalleryAdapter;
import com.example.midterm_android.adapter.MiniPetAdapter;
import com.example.midterm_android.adapter.PetAdapter;
import com.example.midterm_android.databinding.FragmentPetsListBinding;
import com.example.midterm_android.databinding.FragmentProfileBinding;
import com.example.midterm_android.model.Pet;
import com.example.midterm_android.model.SinhVien;
import com.example.midterm_android.view.LoginActivity;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ArrayList<Pet> pets;
    private MiniPetAdapter petAdapter;
    ArrayList<Integer> images;
    GalleryAdapter galleryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.ibLogout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        SinhVien sinhVien = (SinhVien) getActivity().getIntent().getSerializableExtra("sinhVienNe");

        if (sinhVien != null) {
            binding.tvNameProfile.setText(sinhVien.getHoTen().toString());
            binding.tvMailProfile.setText(sinhVien.getEmail().toString());
        }
        addPets();
        addGallery();

        binding.tvPetsCount.setText(getResources().getString(R.string.count, 5));
        binding.tvFriendsCount.setText(getResources().getString(R.string.count, 20));

        petAdapter = new MiniPetAdapter(getContext(), pets);
        binding.rvPets.setAdapter(petAdapter);
        binding.rvPets.setHasFixedSize(true);

        galleryAdapter = new GalleryAdapter(getContext(), images);
        binding.rvGalleryProfile.setAdapter(galleryAdapter);
        binding.rvGalleryProfile.setHasFixedSize(true);

        return binding.getRoot();
    }

    private void addPets() {
        pets = new ArrayList<>();
        pets.add(new Pet("Kileonmusk", "Hasky", true, 6, 45.5, 111.11, "Red", "gaugau", R.drawable.pet1));
        pets.add(new Pet("Shibaxianua", "Chihuahua", false, 12, 100.2, 150.12, "B&W", "grrrrr", R.drawable.pet2));
        pets.add(new Pet("Hanakem Cheese", "Maddog", false, 3, 15.6, 30.77, "White", "angang", R.drawable.pet3));
        pets.add(new Pet("Betting Helloyboy", "Beandog", true, 2, 140.2, 70.2, "Gray", "ecec", R.drawable.pet4));
        pets.add(new Pet("Brusk", "Cherry", false, 1, 140.2, 70.2, "Gray", "kiiiii", R.drawable.pet5));
    }

    private void addGallery() {
        images = new ArrayList<>();
        images.add(R.drawable.pet1);
        images.add(R.drawable.pet2);
        images.add(R.drawable.pet3);
        images.add(R.drawable.pet4);
        images.add(R.drawable.pet5);
        images.add(R.drawable.pet6);
        images.add(R.drawable.pet3);
        images.add(R.drawable.pet1);
        images.add(R.drawable.pet4);
    }
}