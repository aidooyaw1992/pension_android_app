package com.faabsystems.pensionapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.faabsystems.pensionapplication.data.remote.response.UsersResponse;
import com.faabsystems.pensionapplication.databinding.FragmentHomeBinding;
import com.faabsystems.pensionapplication.util.DataState;
import com.faabsystems.pensionapplication.vm.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private UserViewModel userViewModel;


    private FragmentHomeBinding fragmentHomeBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        return fragmentHomeBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        fragmentHomeBinding.cvPensioneers.setOnClickListener(v-> {

            navController.navigate(R.id.action_homeFragment_to_userListFragment);
            Toast.makeText(requireContext(), "Pressed", Toast.LENGTH_SHORT).show();


        });

        fragmentHomeBinding.btnSettings.setOnClickListener(v->{
            navController.navigate(R.id.action_homeFragment_to_settingsFragment);
        });

        userViewModel.getUser().observe(getViewLifecycleOwner(), listDataState -> {
            if (listDataState.getStatus() == DataState.Status.SUCCESS){
                for (UsersResponse usersResponse: listDataState.getData()){
                    Log.d("UserList", usersResponse.toString());
                }
            }
        });

    }
}