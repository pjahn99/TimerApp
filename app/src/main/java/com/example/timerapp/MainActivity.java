package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText minuteEdit ;
    private TextView timerText ;
    private Button timerButton ;
    private CountDownTimer timer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = findViewById(R.id.timer_text)  ;
        timerButton = findViewById(R.id.timer_button) ;
        minuteEdit= findViewById(R.id.minute) ;

        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long millisInFuture = 1000 * 60 * Integer.valueOf(minuteEdit.getText().toString()) ;

                if(timer!= null){
                    timer.cancel();
                }

                timer = new CountDownTimer(millisInFuture,1000) {
                    @Override
                    public void onTick(long millisInFuture) {
                        long minutes = millisInFuture / 1000 / 60 ;
                        long seconds= (millisInFuture / 1000 ) % 60 ;
                        timerText.setText(minutes+ ":"+ seconds);
                    }

                    @Override
                    public void onFinish() {
                        timerText.setText("Take a break! :) ");
                    }
                } ;
                timer.start() ;
            }
        });
    }
}