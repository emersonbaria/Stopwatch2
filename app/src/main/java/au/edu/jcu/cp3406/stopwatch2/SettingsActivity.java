package au.edu.jcu.cp3406.stopwatch2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    public static final int SETTINGS_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void doneClicked(View view) {
        EditText input = findViewById(R.id.timerSpeedInput);
        String speed = input.getText().toString();
        int intSpeed = Integer.parseInt(speed);
        Intent intent = new Intent();
        intent.putExtra("speed", intSpeed);
        setResult(RESULT_OK, intent);
        finish();
    }
}
