package com.example.health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int stepsCounter = 1;
    int goalCounter = 100;
    float currentProgressFloat = (float) stepsCounter / goalCounter;
    int currentProgress = (int) (currentProgressFloat * 100);

    TextView stepsCurrent;
    TextView stepsGoal;
    TextView stepsPercent;
    ProgressBar stepsProgressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initDefaultValues();
        initListeners();
    }

    public void findViews() {
        stepsCurrent = (TextView) findViewById(R.id.steps_current);
        stepsGoal = (TextView) findViewById(R.id.steps_goal);
        stepsProgressbar = (ProgressBar) findViewById(R.id.steps_progressbar);
        stepsPercent = (TextView) findViewById(R.id.steps_percent_counter);
    }

    public void initDefaultValues() {
        stepsCurrent.setText(String.valueOf(stepsCounter));
        stepsGoal.setText(String.valueOf(goalCounter));
        stepsPercent.setText(String.valueOf(currentProgress));
        stepsProgressbar.setProgress(currentProgress);
    }

    public void initListeners() {
        stepsCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stepsCounter < goalCounter) {
                    stepsCounter++;
                    currentProgressFloat = (float) stepsCounter / goalCounter;
                    currentProgress = (int) (currentProgressFloat * 100);
                    stepsCurrent.setText(String.valueOf(stepsCounter));
                    stepsProgressbar.setProgress(currentProgress);
                    stepsPercent.setText(String.valueOf(currentProgress));
                }
            }
        });
    }
}