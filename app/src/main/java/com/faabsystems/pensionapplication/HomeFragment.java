package com.faabsystems.pensionapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.faabsystems.pensionapplication.databinding.FragmentHomeBinding;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {


    private FragmentHomeBinding fragmentHomeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater);


        return fragmentHomeBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        fragmentHomeBinding.cvEnrolBiometric.setOnClickListener(v -> {

            navController.navigate(R.id.action_homeFragment_to_userBiometricRegistrationFragment);
            Toast.makeText(requireContext(), "Pressed", Toast.LENGTH_SHORT).show();


        });

        fragmentHomeBinding.btnSettings.setOnClickListener(v -> {
            navController.navigate(R.id.action_homeFragment_to_settingsFragment);
        });


    }
}