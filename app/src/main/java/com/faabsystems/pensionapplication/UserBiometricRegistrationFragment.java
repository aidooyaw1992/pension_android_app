package com.faabsystems.pensionapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.faabsystems.pensionapplication.databinding.FragmentUserBiometricRegistrationBinding;

public class UserBiometricRegistrationFragment extends Fragment {

    private FragmentUserBiometricRegistrationBinding fragmentUserBiometricRegistrationBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        fragmentUserBiometricRegistrationBinding = FragmentUserBiometricRegistrationBinding.inflate(inflater);
        return fragmentUserBiometricRegistrationBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}