package ru.samsung.academy.a17.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import ru.samsung.academy.a17.model.Person;
import ru.samsung.academy.a17.model.PersonRepository;

public class MainViewModel extends ViewModel {

    private final PersonRepository personRepository;

    private MainViewModel(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private final MutableLiveData<ArrayList<Person>> dataPersons = new MutableLiveData<>();

    public void addPerson(Person person) {
        personRepository.addPerson(person);
        dataPersons.setValue(personRepository.getPersonArrayList());
    }

    public MutableLiveData<ArrayList<Person>> getPerson() {
        return dataPersons;
    }

    public static class MainViewModelFactory implements ViewModelProvider.Factory {

        private final PersonRepository personRepository;
        public MainViewModelFactory(PersonRepository personRepository) {
            this.personRepository = personRepository;
        }
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(personRepository);
        }
    }


}
