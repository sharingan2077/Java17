package ru.samsung.academy.a17.utils;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.Toast;

public class NameFilter implements InputFilter {
    private Context context;

    public NameFilter(Context context) {
        this.context = context;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            char symbol = source.charAt(source.length() - 1);
            Log.d("MYTAG", dest.toString() + " " + symbol);
            if (dest.toString().length() == 0 && (symbol < 'А' || symbol > 'Я')) {
                Toast.makeText(context, "Имя должно начинаться с заглавной буквы", Toast.LENGTH_SHORT).show();
                return "";
            }
            if (dest.toString().length() > 0) {
                if (symbol < 'а' || symbol > 'я') return "";
            }
            return null;
        }
        catch (Exception e) {}
        return "";
    }
}
