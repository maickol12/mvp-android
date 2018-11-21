package com.example.rocm9.mvpexample.Presenter;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rocm9.mvpexample.interfaces.ProvidedModel;
import com.example.rocm9.mvpexample.interfaces.ProvidedPresenter;
import com.example.rocm9.mvpexample.interfaces.RequiredPresenter;
import com.example.rocm9.mvpexample.interfaces.RequiredView;

public class MainActivityPresenter implements ProvidedPresenter,RequiredPresenter {
    private ProvidedModel mModel;
    private RequiredView mView;

    public MainActivityPresenter(RequiredView view){
        this.mView = view;
    }

    public void setView(RequiredView view){
        this.mView = view;
    }

    @Override
    public void clickNewText(EditText text) {
        String texto = mModel.insertText(text.getText().toString());
        mView.refreshText(texto);
    }

    @Override
    public Context getAppContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    public void setModel(ProvidedModel mModel){
        this.mModel = mModel;
    }
}
