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
import com.faabsystems.pensionapplication.util.DataStateListener;
import com.faabsystems.pensionapplication.vm.UserViewModel;

import java.util.List;

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

        //Making post
        /*
        userViewModel.createUser(new User(1,"Leslie"), new DataStateListener<CreateUserResponse>() {
            @Override
            public void onLoading() {
                // Handle loading state (show progress bar, etc.)
            }

            @Override
            public void onSuccess(CreateUserResponse data) {
                // Handle success (user created)
            }

            @Override
            public void onError(String errorMessage) {
                // Handle error (creation failed)
            }
        });

         */


        userViewModel.getUser(new DataStateListener<List<UsersResponse>>() {
            @Override
            public void onLoading() {
                // Handle loading state (show progress bar, etc.)
            }

            @Override
            public void onSuccess(List<UsersResponse> data) {
                Log.d("Users->>>", data.get(0).getTitle());

            }

            @Override
            public void onError(String errorMessage) {
                // Handle error (creation failed)
            }
        });
    }
}