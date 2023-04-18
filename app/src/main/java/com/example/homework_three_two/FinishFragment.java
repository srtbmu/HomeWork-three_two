package com.example.homework_three_two;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FinishFragment extends Fragment {
    TextView TextName, TextSurname, TextAge, TextFloor, TextStudy, TextWork;
    String Name, Surname, Age, Floor, Study, Work;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniViewId();
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Name = bundle.getString("Name");
            Surname = bundle.getString("Surname");
            Age = bundle.getString("Age");
            Floor = bundle.getString("Floor");
            Study = bundle.getString("Study");
            Work = bundle.getString("Work");
            TextName.setText(Name);
            TextSurname.setText(Surname);
            TextAge.setText(Age);
            TextFloor.setText(Floor);
            TextStudy.setText(Study);
            TextWork.setText(Work);
        }
    }

    private void iniViewId() {
        TextName = requireActivity().findViewById(R.id.TextName);
        TextSurname = requireActivity().findViewById(R.id.TextSurname);
        TextAge = requireActivity().findViewById(R.id.TextAge);
        TextFloor = requireActivity().findViewById(R.id.TextFloor);
        TextStudy = requireActivity().findViewById(R.id.TextStudies);
        TextWork = requireActivity().findViewById(R.id.TextWork);
    }
}