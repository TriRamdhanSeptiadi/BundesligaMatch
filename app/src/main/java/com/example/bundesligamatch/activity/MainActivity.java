package com.example.bundesligamatch.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.bundesligamatch.R;
import com.example.bundesligamatch.databinding.ActivityMainBinding;
import com.example.bundesligamatch.fragment.MatchFragment;
import com.example.bundesligamatch.fragment.StandingFragment;
import com.example.bundesligamatch.fragment.TeamFragment;

// NIM                               : 10120232
// Nama                              : Tri Ramdhan Septiadi
// Kelas                             : IF-6

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new TeamFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.item_team:
                    replaceFragment(new TeamFragment());
                    break;
                case R.id.item_standing:
                    replaceFragment(new StandingFragment());
                    break;
                case R.id.item_match:
                    replaceFragment(new MatchFragment());
                    break;
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl,fragment);
        fragmentTransaction.commit();
    }

}