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

public class FirstFragment extends Fragment {

    AppCompatButton button;
    EditText editName, editSurname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViews();
        setClicks();
    }

    private void iniViews() {
        button = requireActivity().findViewById(R.id.firsButton);
        editName = requireActivity().findViewById(R.id.EditName);
        editSurname = requireActivity().findViewById(R.id.EditSurname);
    }

    private void setClicks() {
        button.setOnClickListener(view -> {
            if (!editName.getText().toString().isEmpty() && !editSurname.getText().toString().isEmpty()) {
                navigateToSecond();
            } else {
                Toast.makeText(getActivity(), "Введите ваше имя и фамилию", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToSecond() {
        String Name = editName.getText().toString();
        String Surname = editSurname.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("Name", Name);
        bundle.putString("Surname", Surname);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_view, secondFragment)
                .addToBackStack(null)
                .commit();
    }

}
