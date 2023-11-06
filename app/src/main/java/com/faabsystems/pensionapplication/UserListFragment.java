package com.faabsystems.pensionapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.faabsystems.pensionapplication.databinding.FragmentSettingsBinding;
import com.faabsystems.pensionapplication.databinding.FragmentUserListBinding;

import java.util.ArrayList;


public class UserListFragment extends Fragment {
   private FragmentUserListBinding fragmentUserListBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        fragmentUserListBinding = FragmentUserListBinding.inflate(inflater);
        return fragmentUserListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);
        ArrayList<Pensioneer> arrayList = new ArrayList<>();
        arrayList.add(new Pensioneer("100", "Daniel Aidoo"));
        arrayList.add(new Pensioneer("101", "Samuel"));
        arrayList.add(new Pensioneer("101", "Samuel"));
        arrayList.add(new Pensioneer("101", "Samuel"));
        arrayList.add(new Pensioneer("101", "Samuel"));
        arrayList.add(new Pensioneer("101", "Samuel"));
        arrayList.add(new Pensioneer("101", "Samuel"));
        arrayList.add(new Pensioneer("101", "Samuel"));

        PensionListAdapter listAdapter = new PensionListAdapter(arrayList);
        fragmentUserListBinding.rvPensionList.setHasFixedSize(true);
        fragmentUserListBinding.rvPensionList.setLayoutManager(new LinearLayoutManager(view.getContext()));

        fragmentUserListBinding.rvPensionList.setAdapter(listAdapter);



        fragmentUserListBinding.myToolbar.setNavigationOnClickListener(v->{
            navController.navigateUp();
//            Toast.makeText(requireContext(), "Clicked back button", Toast.LENGTH_SHORT).show();
        });
    }
}