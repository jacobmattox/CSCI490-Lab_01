package com.example.csci490_lab_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime = 50 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);
        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new CountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime));
    }


    @Override
    public void onClick(View v) {
        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("Start");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("Reset");
        }

    }

    public class CountDownTimer extends android.os.CountDownTimer {

        public CountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }


        public void onFinish() {
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
        }

        public void onTick(long millisUntilFinished) {
            text.setText("Time remain: " + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
        }
    }
}
