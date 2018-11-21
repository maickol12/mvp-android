package com.example.rocm9.mvpexample.interfaces;

import android.content.Context;

public interface RequiredView {
    Context getContext();

    Context getActivityContext();

    void refreshText(String newText);
}
