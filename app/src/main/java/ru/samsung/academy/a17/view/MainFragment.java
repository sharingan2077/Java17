package ru.samsung.academy.a17.view;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;

import ru.samsung.academy.a17.R;
import ru.samsung.academy.a17.databinding.FragmentMainBinding;
import ru.samsung.academy.a17.dependencies.MyApplication;
import ru.samsung.academy.a17.model.Person;
import ru.samsung.academy.a17.model.UserImages;
import ru.samsung.academy.a17.utils.AgeFilter;
import ru.samsung.academy.a17.utils.NameFilter;
import ru.samsung.academy.a17.viewmodel.MainViewModel;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private MainViewModel mainViewModel;
    private MyApplication myApplication;
    private int[] userImages = UserImages.getUserImages();
    private int index = 0;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        binding = FragmentMainBinding.inflate(inflater);
        myApplication = (MyApplication) requireActivity().getApplication();
        mainViewModel = new ViewModelProvider(requireActivity(),
                new MainViewModel.MainViewModelFactory(myApplication.getRepository()))
                .get(MainViewModel.class);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.inputAge.setFilters(new InputFilter[]{new AgeFilter()});
        binding.inputName.setFilters(new InputFilter[]{new NameFilter(requireActivity())});

        binding.buttonAdd.setOnClickListener(v -> {
            String name = binding.inputName.getText().toString();
            String age = binding.inputAge.getText().toString();
            boolean isMale = binding.buttonMale.isChecked();
            if (name.length() > 0 && age.length() > 0) {
                Person person = new Person(name, Integer.parseInt(age), isMale, userImages[index]);
                mainViewModel.addPerson(person);
                Toast.makeText(requireContext(), "Успешно добавлено!", Toast.LENGTH_SHORT).show();
            }
            else if (name.length() == 0) {
                Toast.makeText(requireContext(), "Введите имя", Toast.LENGTH_SHORT).show();
            }
            else  {
                Toast.makeText(requireContext(), "Введите возраст", Toast.LENGTH_SHORT).show();
            }
        });

        binding.personImage.setOnClickListener(v -> {
            index = (index + 1) % userImages.length;
            binding.personImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(),
                    userImages[index],
                    requireActivity().getTheme()));
        });

        binding.buttonToPersons.setOnClickListener(v -> {
            NavHostFragment navHostFragment = (NavHostFragment)requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
            navHostFragment.getNavController().navigate(R.id.action_mainFragment_to_personsFragment);
        });
    }
}
