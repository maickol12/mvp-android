package com.example.rocm9.mvpexample.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rocm9.mvpexample.Model.MainActivityModel;
import com.example.rocm9.mvpexample.Presenter.MainActivityPresenter;
import com.example.rocm9.mvpexample.R;
import com.example.rocm9.mvpexample.common.StateMaintainer;
import com.example.rocm9.mvpexample.interfaces.ProvidedPresenter;
import com.example.rocm9.mvpexample.interfaces.RequiredView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RequiredView {

    private ProvidedPresenter mPresenter;
    private TextView helloWord;
    private Button changeText;
    private EditText txt;
    private final StateMaintainer mStateMaintainer = new StateMaintainer( getFragmentManager(), MainActivity.class.getName());

    private void setupMVP(){
        if(mStateMaintainer.firstTimeIn()) {
            MainActivityPresenter presenter = new MainActivityPresenter(this);
            MainActivityModel model = new MainActivityModel(presenter);
            presenter.setModel(model);
            mPresenter = presenter;
        }else{
            mPresenter = mStateMaintainer.get(MainActivityPresenter.class.getName());
            // Updated the View in Presenter
            mPresenter.setView(this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWord = (TextView) findViewById(R.id.helloWord);
        txt = (EditText) findViewById(R.id. edit);
        changeText = (Button) findViewById(R.id.changeText);
        changeText.setOnClickListener(this);

        setupMVP();
    }

    @Override
    public void onClick(View v) {
        mPresenter.clickNewText(txt);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    @Override
    public void refreshText(String newText) {
        helloWord.setText(newText);
    }
}
