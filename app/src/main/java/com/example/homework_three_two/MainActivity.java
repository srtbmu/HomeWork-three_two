package com.example.homework_three_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            navigateToFragment();
        }

        private void navigateToFragment() {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_view, new FirstFragment())
                    .commit();
        }
    }
