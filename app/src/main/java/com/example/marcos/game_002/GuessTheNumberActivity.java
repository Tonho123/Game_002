package com.example.marcos.game_002;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Marcos on 18/06/2016.
 */
public class GuessTheNumberActivity extends Activity
{
    private int mCurrentNumber;

    private static final String TAG = "GuessTheNumber";

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela);
        Random random = new Random();
        mCurrentNumber=random.nextInt(11);
        Log.d(TAG, "número a ser encontrado " + String.valueOf(mCurrentNumber));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart1 executado.");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume1 executado");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause executado");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "onRestart executado");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop executado");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy executado");
    }

    public void compareNumbers(View v)
    {
        EditText edtGuess = (EditText) findViewById(R.id.edtGuess);
        TextView txtAnswer = (TextView) findViewById(R.id.txtAnswer);

        if(edtGuess.getText().toString().length()==0)
        {
            txtAnswer.setText("The answer fild is empty");
        }
        else {
            int number = Integer.valueOf(edtGuess.getText().toString());
            Log.d(TAG, "palpite do jogador: " + String.valueOf(number));
            if (number < mCurrentNumber) {
                txtAnswer.setText(R.string.low);
                edtGuess.setText("");
            } else if (number > mCurrentNumber) {
                txtAnswer.setText(R.string.high);
                edtGuess.setText("");
            } else {
                txtAnswer.setText(R.string.correct);
            }
        }
    }
}
