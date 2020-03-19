package com.example.learnengish_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.learnengish_android.view.CategoryActivity;
import com.example.learnengish_android.view.HomeFragmnet;
import com.example.learnengish_android.view.ProcessFragment;
import com.example.learnengish_android.view.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        button =  findViewById(R.id.start);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openCategoryActivity();
//            }
//        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragmnet()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.progress:
                    selectedFragment = new ProcessFragment();
                    break;
                case R.id.menuStart:
                    selectedFragment = new HomeFragmnet();
                    break;
                case R.id.settings:
                    selectedFragment = new SettingFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return false;
        }
    };


    public void openCategoryActivity(){
        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

}
