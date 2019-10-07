package com.example.palacegamestate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createState = findViewById(R.id.createState);
        createState.setOnClickListener(this);

        GameState gs = new GameState();
    }

    @Override
    public void onClick(View view) {

    }
}
