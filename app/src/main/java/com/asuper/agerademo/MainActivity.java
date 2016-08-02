package com.asuper.agerademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.agera.Updatable;

public class MainActivity extends AppCompatActivity implements Updatable {
    private MyObservable myObservable;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);
        myObservable = new MyObservable();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myObservable.setContent("Onclick");
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        myObservable.addUpdatable(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        myObservable.removeUpdatable(this);
    }

    @Override
    public void update() {
        mTextView.setText(myObservable.getContent());
    }
}
