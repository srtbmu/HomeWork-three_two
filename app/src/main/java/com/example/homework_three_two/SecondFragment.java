package com.example.homework_three_two;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SecondFragment extends Fragment {
    AppCompatButton SecondButton;
    EditText editTextAge, editTextFloor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViews();
        setClicks();
    }

    private void iniViews() {
        SecondButton = requireActivity().findViewById(R.id.SecondButton);
        editTextAge = requireActivity().findViewById(R.id.EditAge);
        editTextFloor = requireActivity().findViewById(R.id.EditFloor);
    }

    private void setClicks() {
        SecondButton.setOnClickListener(view -> {
            if (!editTextAge.getText().toString().isEmpty() && !editTextFloor.getText().toString().isEmpty()) {
                navigateToThree();
            } else {
                Toast.makeText(getActivity(), "Введите ваш возраст и пол", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigateToThree() {
        String Age = editTextAge.getText().toString();
        String Floor = editTextFloor.getText().toString();
        Bundle bundle = getArguments();
        bundle.putString("Age", Age);
        bundle.putString("Floor", Floor);
        ThreeFragment threeFragment = new ThreeFragment();
        threeFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, threeFragment)
                .addToBackStack(null)
                .commit();
    }
}
