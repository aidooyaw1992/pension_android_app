package com.faabsystems.pensionapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.faabsystems.pensionapplication.adapter.PensionListAdapter;
import com.faabsystems.pensionapplication.data.remote.response.UsersResponse;
import com.faabsystems.pensionapplication.databinding.FragmentUserListBinding;
import com.faabsystems.pensionapplication.util.DataState;
import com.faabsystems.pensionapplication.vm.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class UserListFragment extends Fragment implements PensionListAdapter.OnItemClickListener {
   private FragmentUserListBinding fragmentUserListBinding;

    private UserViewModel userViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        fragmentUserListBinding = FragmentUserListBinding.inflate(inflater);
        return fragmentUserListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);


        userViewModel.getUser().observe(getViewLifecycleOwner(), listDataState -> {
            if (listDataState.getStatus() == DataState.Status.SUCCESS){
              PensionListAdapter listAdapter = new PensionListAdapter(listDataState.getData(), this);
                fragmentUserListBinding.rvPensionList.setHasFixedSize(true);
                fragmentUserListBinding.rvPensionList.setLayoutManager(new LinearLayoutManager(view.getContext()));
                fragmentUserListBinding.rvPensionList.setAdapter(listAdapter);
            } else if (listDataState.getStatus() == DataState.Status.ERROR) {
                fragmentUserListBinding.userListLoader.setVisibility(View.GONE);
            }else{
                fragmentUserListBinding.userListLoader.setVisibility(View.VISIBLE);
            }
        });






        fragmentUserListBinding.myToolbar.setNavigationOnClickListener(v->{
            navController.navigateUp();
//            Toast.makeText(requireContext(), "Clicked back button", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onItemClick(UsersResponse item) {
        final NavController navController = Navigation.findNavController(requireView());
        navController.navigate(UserListFragmentDirections.actionUserListFragmentToUserBiometricRegistrationFragment(item));


        Toast.makeText(requireContext(),item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}