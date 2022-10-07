package com.example.midterm_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.midterm_android.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets;
    PetAdapter petAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | /*View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |*/ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.topAppBar.setNavigationOnClickListener(v -> onBackPressed()
                // Handle navigation icon press
        );

        pets = new ArrayList<>();
        addPets();
        petAdapter = new PetAdapter(this, pets);
        binding.rvPet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvPet.setAdapter(petAdapter);
    }

    private void addPets() {
        pets.add(new Pet("Trần Đức Mạnh", "Hasky", true, 6, 45.5, 111.11, "Red", "hehe", R.drawable.pet1));
        pets.add(new Pet("Huỳnh Tấn Lực", "Chihuahua", true, 12, 100.2, 150.12, "B&W", "hoho", R.drawable.pet2));
        pets.add(new Pet("Trần Thị Kim Ngân", "Maddog", false, 3, 15.6, 30.77, "White", "huhu", R.drawable.pet3));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
        pets.add(new Pet("Hồ Quang Phúc", "Liverpool", true, 24, 140.2, 70.2, "Gray", "hihi", R.drawable.pet4));
    }
}