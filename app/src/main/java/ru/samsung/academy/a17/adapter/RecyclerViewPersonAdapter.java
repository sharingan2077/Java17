package ru.samsung.academy.a17.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.samsung.academy.a17.databinding.ItemPersonBinding;
import ru.samsung.academy.a17.model.Person;

public class RecyclerViewPersonAdapter extends RecyclerView.Adapter<RecyclerViewPersonAdapter.PersonViewHolder> {

    private ArrayList<Person> listPerson = new ArrayList<>();

    public void setListPerson(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPersonBinding binding = ItemPersonBinding.inflate(layoutInflater, parent, false);
        return new PersonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.bind(listPerson.get(position));
    }

    @Override
    public int getItemCount() {
        return listPerson.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {
       private ItemPersonBinding binding;
       PersonViewHolder(ItemPersonBinding binding) {
           super(binding.getRoot());
           this.binding = binding;
       }
       void bind(Person person) {
           binding.imagePerson.setImageDrawable(ResourcesCompat.getDrawable(
                   binding.getRoot().getContext().getResources(),
                   person.getAvatar(),
                   binding.getRoot().getContext().getTheme()
           ));
           String name = "Имя: " + person.getName();
           String age = "Возраст: " + person.getAge() + " лет";
           String male = (person.isMale()) ? "Мужчина" : "Женщина";
           String sex = "Пол: " + male;
           binding.textName.setText(name);
           binding.textAge.setText(age);
           binding.textSex.setText(sex);
       }


   }


}
