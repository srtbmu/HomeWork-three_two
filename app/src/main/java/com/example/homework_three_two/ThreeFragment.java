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

    public class ThreeFragment extends Fragment {

        AppCompatButton button;
        EditText editStudy, editWork;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_three, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            iniViews();
            setClicks();
        }

        private void iniViews() {
            button = requireActivity().findViewById(R.id.ThreeButton);
            editStudy = requireActivity().findViewById(R.id.EditPlaceOfStudy);
            editWork = requireActivity().findViewById(R.id.EditWork);
        }

        private void setClicks() {
            button.setOnClickListener(view -> {
                if (!editStudy.getText().toString().isEmpty() && !editWork.getText().toString().isEmpty()) {
                    navigateToFinish();
                } else {
                    Toast.makeText(getActivity(), "Введите место учебы и место работы", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void navigateToFinish() {
            String Study = editStudy.getText().toString();
            String Work = editWork.getText().toString();
            Bundle bundle = getArguments();
            bundle.putString("Study", Study);
            bundle.putString("Work", Work);
            FinishFragment finishFragment = new FinishFragment();
            finishFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, finishFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
