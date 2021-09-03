package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;

import com.example.rentit.databinding.ActivityMainBinding;
import com.example.rentit.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
       ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent !=null){
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
            int imageId = intent.getIntExtra("imageId",R.drawable.rent);

            binding.nameprofile.setText(name);
            binding.phoneprofile.setText(phone);
            binding.countryprofile.setText(country);
            binding.profileImage.setImageResource(imageId);
        }
    }
}