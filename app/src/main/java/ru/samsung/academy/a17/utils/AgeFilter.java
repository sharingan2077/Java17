package ru.samsung.academy.a17.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class AgeFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int age = Integer.parseInt(dest.toString() + source);
            if (isInRange(age)) return null;
        }
        catch (NumberFormatException exception) {}
        return "";
    }

    private boolean isInRange(int age) {
        return age > 0 && age < 111;
    }
}
