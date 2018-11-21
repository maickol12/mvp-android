package com.example.rocm9.mvpexample.Model;

import com.example.rocm9.mvpexample.interfaces.ProvidedModel;
import com.example.rocm9.mvpexample.interfaces.RequiredPresenter;

public class MainActivityModel implements ProvidedModel {

    private RequiredPresenter presenter;

    public MainActivityModel(RequiredPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public String insertText(String newText) {
        return newText;
    }
}
