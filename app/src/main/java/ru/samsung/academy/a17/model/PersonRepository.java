package ru.samsung.academy.a17.model;

import java.util.ArrayList;

public class PersonRepository {

    private ArrayList<Person> personArrayList = new ArrayList<>();

    public void addPerson(Person person) {
        personArrayList.add(person);
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }
}
