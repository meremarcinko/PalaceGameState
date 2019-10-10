package com.example.palacegamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    private EditText stateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createState = findViewById(R.id.createState);
        createState.setOnClickListener(this);

        stateDisplay = findViewById(R.id.stateDisplay);


    }

    @Override
    public void onClick(View view)
    {

        GameState firstInstance = new GameState();
        for (Pair p : firstInstance.the_deck)
        {
            if (p.get_location() == Pair.Location.PLAYER_ONE_HAND)
            {
                firstInstance.selectCards(1, p);
                break;
            }
        }

        firstInstance.playCards(1);
        firstInstance.takeDiscardPile(2);
        stateDisplay.setText(firstInstance.toString());


    }
}