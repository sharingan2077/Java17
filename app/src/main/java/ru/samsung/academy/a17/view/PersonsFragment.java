package ru.samsung.academy.a17.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import ru.samsung.academy.a17.R;
import ru.samsung.academy.a17.adapter.RecyclerViewPersonAdapter;
import ru.samsung.academy.a17.databinding.FragmentPersonsBinding;
import ru.samsung.academy.a17.viewmodel.MainViewModel;

public class PersonsFragment extends Fragment {

    private FragmentPersonsBinding binding;
    private MainViewModel mainViewModel;
    private RecyclerViewPersonAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPersonsBinding.inflate(inflater);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        binding.recyclerViewPerson.setLayoutManager(new LinearLayoutManager(requireActivity()));
        adapter = new RecyclerViewPersonAdapter();
        binding.recyclerViewPerson.setAdapter(adapter);

        mainViewModel.getPerson().observe(requireActivity(), personArrayList -> {
            adapter.setListPerson(personArrayList);
            adapter.notifyDataSetChanged();
        });
        binding.buttonToMain.setOnClickListener(v -> {
            NavHostFragment navHostFragment = (NavHostFragment)requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
            navHostFragment.getNavController().navigate(R.id.action_personsFragment_to_mainFragment);
        });

        return binding.getRoot();
    }
}
