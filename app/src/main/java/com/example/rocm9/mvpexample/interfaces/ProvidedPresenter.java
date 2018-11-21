package com.example.rocm9.mvpexample.interfaces;

import android.widget.EditText;
import android.widget.TextView;

public interface ProvidedPresenter {
    void clickNewText(EditText editText);
    void setView(RequiredView mView);
}
