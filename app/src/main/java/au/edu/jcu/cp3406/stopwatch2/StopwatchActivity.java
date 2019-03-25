package au.edu.jcu.cp3406.stopwatch2;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private boolean isRunning;
    private Handler handler;
    TextView display;
    Button toggle;
    Stopwatch stopwatch;
    int speed =1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        display = findViewById(R.id.time_view);
        toggle = findViewById(R.id.toggle);

        isRunning=false;
        if (savedInstanceState == null) {
            stopwatch = new Stopwatch();
        } else {
            String string = savedInstanceState.getString("stopwatch");
            display.setText(string);
            boolean running = savedInstanceState.getBoolean("running");
            if (running) {
                enableStopwatch();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("stopwatch",stopwatch.toString());
        outState.putBoolean("running", isRunning);

    }

    public void enableStopwatch() {
        isRunning = true;
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    stopwatch.tick();
                    display.setText(stopwatch.toString());
                }
                handler.postDelayed(this, speed);
            }
        });

    }

    public void disableStopwatch() {
        isRunning=false;
        stopwatch.reset();
        display.setText("00:00:00");

    }

    public void buttonClicked(View view) {
        toggle = findViewById(R.id.toggle);
        String btnLabel=toggle.getText().toString();
        if (btnLabel.equals("Start")) {
            toggle.setText("Stop");
            enableStopwatch();
        } else if (btnLabel.equals("Stop")) {
            toggle.setText("Start");
            disableStopwatch();
        }
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SettingsActivity.SETTINGS_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    speed = data.getIntExtra("speed", 1000);
                }
            }
        }
    }


}
