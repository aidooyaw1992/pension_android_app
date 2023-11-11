package com.faabsystems.pensionapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.faabsystems.pensionapplication.databinding.FragmentUserBiometricRegistrationBinding;

public class UserBiometricRegistrationFragment extends Fragment {

    private FragmentUserBiometricRegistrationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentUserBiometricRegistrationBinding.inflate(inflater);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        String title = UserBiometricRegistrationFragmentArgs.fromBundle(getArguments()).getUsersResponse().getTitle();
//        String userId = UserBiometricRegistrationFragmentArgs.fromBundle(getArguments()).getUsersResponse().getUserId();
//
//        Toast.makeText(requireContext(), title, Toast.LENGTH_LONG).show();
//        fragmentUserBiometricRegistrationBinding.detailsFullNameValue.setText(title);
//        fragmentUserBiometricRegistrationBinding.detailsDescriptionValue.setText(userId);


    }
}