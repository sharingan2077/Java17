package ru.samsung.academy.a17.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;

import ru.samsung.academy.a17.dependencies.MyApplication;
import ru.samsung.academy.a17.databinding.ActivityMainBinding;
import ru.samsung.academy.a17.model.Person;
import ru.samsung.academy.a17.model.UserImages;
import ru.samsung.academy.a17.utils.AgeFilter;
import ru.samsung.academy.a17.utils.NameFilter;
import ru.samsung.academy.a17.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }




}