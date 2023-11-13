package ru.samsung.academy.a17.dependencies;

import android.app.Application;

import ru.samsung.academy.a17.model.PersonRepository;

public class MyApplication extends Application {

    private PersonRepository repository = new PersonRepository();

    public PersonRepository getRepository() {
        return repository;
    }
}
